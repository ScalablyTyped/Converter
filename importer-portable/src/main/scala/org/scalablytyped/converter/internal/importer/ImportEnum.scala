package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.transforms.CleanIllegalNames
import org.scalablytyped.converter.internal.ts._

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
      anns:         IArray[ClassAnnotation],
      scope:        TsTreeScope,
      importName:   AdaptiveNamingImport,
      importType:   ImportType,
      illegalNames: CleanIllegalNames,
  ): IArray[Tree] =
    e match {
      /* exported const enum? type alias */
      case TsDeclEnum(cs, _, true, _, _, _, Some(exportedFrom), _, codePath) =>
        val tpe        = importType(Wildcards.No, scope, importName)(exportedFrom)
        val importedCp = importName(codePath)
        IArray(TypeAliasTree(importedCp.parts.last, Empty, tpe, cs + CommentData(Markers.IsTrivial), importedCp))

      /* normal const enum? type alias. And output a scala object with values if possible, otherwise a comment */
      case TsDeclEnum(cs, _, true, _, members, _, None, _, codePath) =>
        val importedCodePath = importName(codePath)
        val ta = TypeAliasTree(
          name     = importedCodePath.parts.last,
          tparams  = Empty,
          alias    = importType(Wildcards.No, scope, importName)(TsTypeUnion(e.members.map(m => TsExpr.typeOfOpt(m.expr)))),
          comments = cs,
          codePath = importedCodePath,
        )

        def module = {
          val cast = {
            val castName = Name("cast")
            val T        = Name("T")
            MethodTree(
              IArray(Annotation.Inline),
              ProtectionLevel.Private,
              castName,
              IArray(TypeParamTree(T, None, NoComments)),
              IArray(IArray(ParamTree(Name("in"), false, TypeRef.Any, None, NoComments))),
              MemberImpl.Custom("in.asInstanceOf[T]"),
              TypeRef(T),
              isOverride = false,
              NoComments,
              importedCodePath + castName,
            )
          }
          val newMembers = members.map {
            case TsEnumMember(memberCs, ImportName(memberName), exprOpt) =>
              val expr = exprOpt.getOrElse(sys.error("Expression cannot be empty here"))
              val tpe  = importType(Wildcards.No, scope, importName)(TsExpr.typeOf(expr))
              MethodTree(
                IArray(Annotation.Inline),
                ProtectionLevel.Default,
                memberName,
                Empty,
                Empty,
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
          ModuleTree(
            Empty,
            importedCodePath.parts.last,
            Empty,
            cast +: newMembers,
            related,
            importedCodePath,
            isOverride = false,
          )
        }

        IArray(ta, module)

      /* Any other enum? a type and an object */
      case TsDeclEnum(cs, _, _, _, members, isValue, exportedFrom, _, codePath) =>
        val importedCodePath = importName(codePath)
        val enumName         = importedCodePath.parts.last

        val baseInterface: TypeRef =
          importType(Wildcards.No, scope, importName)(
            TsTypeRef(NoComments, exportedFrom.fold(codePath.forceHasPath.codePath)(_.name), Empty),
          )

        val underlying = underlyingType(e)

        val typeTree: Tree =
          exportedFrom match {
            case Some(ef) =>
              scalajs.TypeAliasTree(
                name     = enumName,
                tparams  = Empty,
                alias    = importType(Wildcards.No, scope, importName)(TsTypeRef(NoComments, ef.name, Empty)),
                comments = Comments(CommentData(Markers.IsTrivial)),
                codePath = importedCodePath,
              )
            case None =>
              ClassTree(
                annotations = IArray(Annotation.JsNative),
                name        = enumName,
                tparams     = Empty,
                parents     = Empty,
                ctors       = Empty,
                members     = Empty,
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
                  annotations = IArray(Annotation.JsBracketAccess),
                  level       = ProtectionLevel.Default,
                  name        = Name.APPLY,
                  tparams     = Empty,
                  params      = IArray(IArray(applyParam)),
                  impl        = MemberImpl.Native,
                  resultType  = TypeRef.Intersection(IArray(baseInterface, underlying)).withOptional(true),
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = importedCodePath + Name.APPLY,
                ),
              )
            } else None

          val membersSyms: IArray[Tree] =
            members flatMap {
              case TsEnumMember(memberCs, ImportName(memberName), exprOpt) =>
                val memberType: Option[ClassTree] =
                  if (exportedFrom.nonEmpty) None
                  else
                    Some(
                      ClassTree(
                        annotations = IArray(Annotation.JsNative),
                        name        = memberName,
                        tparams     = Empty,
                        parents     = IArray(baseInterface),
                        ctors       = Empty,
                        members     = Empty,
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
                        (IArray(Annotation.JsName(memberName)), memberName.withSuffix(""))
                      else (Empty, memberName)

                    val comments =
                      exprOpt.fold(Comments(Nil))(expr => Comments(Comment(s"/* ${TsExpr.format(expr)} */ ")))

                    Some(
                      FieldTree(
                        annotations = anns,
                        name        = name,
                        tpe         = TypeRef.Intersection(IArray(memberTypeRef, underlying)),
                        impl        = MemberImpl.Native,
                        isReadOnly  = true,
                        isOverride  = false,
                        comments    = comments,
                        codePath    = importedCodePath + memberName,
                      ),
                    )
                  } else None

                IArray.fromOptions(memberType, memberValue)
            }

          ModuleTree(
            anns,
            enumName,
            parents    = Empty,
            members    = membersSyms ++ IArray.fromOption(applyMethod),
            comments   = cs + CommentData(Markers.EnumObject),
            codePath   = importedCodePath,
            isOverride = false,
          )
        }

        IArray(moduleTree, typeTree)
    }
}
