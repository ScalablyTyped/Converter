package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.scalajs.transforms.CleanIllegalNames
import com.olvind.tso.ts._

object ImportEnum {
  def underlyingType(e: TsDeclEnum): TypeRef = {
    val found = e.members.collect {
      case TsEnumMember(_, _, Some(TsExpr.Literal(lit))) =>
        lit match {
          case _: TsLiteralString  => TypeRef.String
          case _: TsLiteralNumber  => TypeRef.Double
          case _: TsLiteralBoolean => TypeRef.Boolean
        }
    }
    TypeRef.Union(found, sort = true)
  }

  def apply(
      e:            TsDeclEnum,
      anns:         Seq[ClassAnnotation],
      scope:        TsTreeScope,
      importName:   ImportName,
      importType:   ImportType,
      illegalNames: CleanIllegalNames,
  ): Seq[Tree] =
    e match {
      /* exported const enum? type alias */
      case TsDeclEnum(cs, _, true, importName.assertOne(name), _, _, Some(exportedFrom), _, codePath) =>
        val tpe = importType(Wildcards.No, scope, importName)(exportedFrom)
        List(TypeAliasTree(name, Nil, tpe, cs + CommentData(Markers.IsTrivial), importName(codePath)))

      /* normal const enum? type alias. And output a scala object with values if possible, otherwise a comment */
      case TsDeclEnum(cs, _, true, importName.assertOne(name), members, _, None, _, codePath) =>
        val importedCodePath = importName(codePath)
        val ta = TypeAliasTree(
          name     = name,
          tparams  = Nil,
          alias    = importType(Wildcards.No, scope, importName)(TsTypeUnion(e.members.map(m => TsExpr.typeOfOpt(m.expr)))),
          comments = cs,
          codePath = importedCodePath,
        )

        def module = {
          val cast = {
            val castName = Name("cast")
            val T        = Name("T")
            MethodTree(
              List(Annotation.Inline),
              ProtectionLevel.Private,
              castName,
              List(TypeParamTree(T, None, NoComments)),
              List(List(ParamTree(Name("in"), false, TypeRef.Any, None, NoComments))),
              MemberImpl.Custom("in.asInstanceOf[T]"),
              TypeRef(T),
              isOverride = false,
              NoComments,
              importedCodePath + castName,
            )
          }
          val newMembers = members.map {
            case TsEnumMember(memberCs, importName.assertOne(memberName), exprOpt) =>
              val expr = exprOpt.getOrElse(sys.error("Expression cannot be empty here"))
              val tpe  = importType(Wildcards.No, scope, importName)(TsExpr.typeOf(expr))
              MethodTree(
                List(Annotation.Inline),
                ProtectionLevel.Default,
                memberName,
                Nil,
                Nil,
                MemberImpl.Custom(s"this.cast(${TsExpr.format(expr)})"),
                tpe,
                isOverride = false,
                memberCs,
                importedCodePath + memberName,
              )
          }

          /* keep module members when minimizing */
          val related = Comments(
            CommentData(KeepOnlyReferenced.Related(TypeRef(cast.codePath) +: newMembers.map(m => TypeRef(m.codePath)))),
          )
          ModuleTree(Nil, name, Nil, cast +: newMembers, related, importedCodePath, isOverride = false)
        }

        List(ta, module)

      /* Any other enum? a type and an object */
      case TsDeclEnum(cs, _, _, importName.assertOne(name), members, isValue, exportedFrom, _, codePath) =>
        val importedCodePath = importName(codePath)

        val baseInterface: TypeRef =
          importType(Wildcards.No, scope, importName)(
            TsTypeRef(NoComments, exportedFrom.fold(codePath.forceHasPath.codePath)(_.name), Nil),
          )

        val underlying = underlyingType(e)

        val typeTree: Tree =
          exportedFrom match {
            case Some(ef) =>
              scalajs.TypeAliasTree(
                name     = name,
                tparams  = Nil,
                alias    = importType(Wildcards.No, scope, importName)(TsTypeRef(NoComments, ef.name, Nil)),
                comments = Comments(CommentData(Markers.IsTrivial)),
                codePath = importedCodePath,
              )
            case None =>
              ClassTree(
                annotations = Seq(Annotation.JsNative),
                name        = name,
                tparams     = Nil,
                parents     = Nil,
                ctors       = Nil,
                members     = Nil,
                classType   = ClassType.Trait,
                isSealed    = true,
                comments    = NoComments,
                codePath    = importedCodePath,
              )
          }

        val moduleTree: ModuleTree = {
          val applyMethod: Option[MethodTree] =
            if (isValue) {
              val applyParam = ParamTree(Name.value, false, underlying, None, NoComments)
              Some(
                MethodTree(
                  annotations = Annotation.method(name, isBracketAccess = true),
                  level       = ProtectionLevel.Default,
                  name        = Name.APPLY,
                  tparams     = Nil,
                  params      = Seq(Seq(applyParam)),
                  impl        = MemberImpl.Native,
                  resultType  = TypeRef.Intersection(baseInterface :: underlying :: Nil).withOptional(true),
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = importedCodePath + Name.APPLY,
                ),
              )
            } else None

          val membersSyms: Seq[Tree] =
            members flatMap {
              case TsEnumMember(memberCs, importName.assertOne(memberName), exprOpt) =>
                val memberType: Option[ClassTree] =
                  if (exportedFrom.nonEmpty) None
                  else
                    Some(
                      ClassTree(
                        annotations = Seq(Annotation.JsNative),
                        name        = memberName,
                        tparams     = Nil,
                        parents     = Seq(baseInterface),
                        ctors       = Nil,
                        members     = Nil,
                        classType   = ClassType.Trait,
                        isSealed    = true,
                        comments    = memberCs,
                        codePath    = importedCodePath + memberName,
                      ),
                    )

                val memberTypeRef = baseInterface.copy(typeName = baseInterface.typeName + memberName)

                val memberValue: Option[Tree] =
                  if (isValue) {
                    val (anns, name) =
                      if (illegalNames.Illegal(memberName) || ObjectMembers.byName.contains(memberName))
                        (List(Annotation.JsName(memberName)), memberName.withSuffix(""))
                      else (Nil, memberName)

                    val comments =
                      exprOpt.fold(Comments(Nil))(expr => Comments(Comment(s"/* ${TsExpr.format(expr)} */ ")))

                    Some(
                      FieldTree(
                        annotations = anns,
                        name        = name,
                        tpe         = TypeRef.Intersection(memberTypeRef :: underlying :: Nil),
                        impl        = MemberImpl.Native,
                        isReadOnly  = true,
                        isOverride  = false,
                        comments    = comments,
                        codePath    = importedCodePath + memberName,
                      ),
                    )
                  } else None

                Seq() ++ memberType ++ memberValue
            }

          ModuleTree(
            anns,
            name,
            parents    = Nil,
            members    = membersSyms ++ applyMethod,
            comments   = cs + CommentData(Markers.EnumObject),
            codePath   = importedCodePath,
            isOverride = false,
          )
        }

        Seq(moduleTree, typeTree)
    }
}
