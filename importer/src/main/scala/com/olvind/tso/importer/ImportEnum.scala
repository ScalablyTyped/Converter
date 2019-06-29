package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
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
      e:                   TsDeclEnum,
      anns:                Seq[ClassAnnotation],
      scope:               TsTreeScope,
      importName:          ImportName,
      isWithinScalaModule: Boolean,
  ): Seq[Tree] =
    e match {
      /* exported const enum? type alias */
      case TsDeclEnum(cs, _, true, importName(name), _, _, Some(exportedFrom), _, codePath) =>
        val tpe = ImportType(Wildcards.No, scope, importName)(exportedFrom)
        List(TypeAliasTree(name, Nil, tpe, cs, importName(codePath)))

      /* normal const enum? type alias. And output a scala object with values if possible, otherwise a comment */
      case TsDeclEnum(cs, _, true, importName(name), members, _, None, _, codePath) =>
        val importedCodePath = importName(codePath)
        val ta = {
          val cOpt =
            if (isWithinScalaModule)
              Some(Comment(s"/* Inlined `const enum`. Members: ${members
                .map(m => s"- ${m.name.value}: ${m.expr.fold("<empty>")(TsExpr.format)}")
                .mkString("\n", "\n", "\n")} */\n"))
            else None

          val tpe =
            ImportType(Wildcards.No, scope, importName)(TsTypeUnion(e.members.map(m => TsExpr.typeOfOpt(m.expr))))

          TypeAliasTree(name, Nil, tpe, cs +? cOpt, importedCodePath)
        }

        def module = {
          val cast = {
            val castName = Name("cast")
            val T        = Name("T")
            MethodTree(
              List(Inline),
              Private,
              castName,
              List(TypeParamTree(T, None, NoComments)),
              List(List(ParamTree(Name("in"), TypeRef.Any, None, NoComments))),
              MemberImplCustom("in.asInstanceOf[T]"),
              TypeRef(T),
              isOverride = false,
              NoComments,
              importedCodePath + castName,
            )
          }
          val newMembers = members.map {
            case TsEnumMember(memberCs, importName(memberName), exprOpt) =>
              val expr = exprOpt.getOrElse(sys.error("Expression cannot be empty here"))
              val tpe  = ImportType(Wildcards.No, scope, importName)(TsExpr.typeOf(expr))
              MethodTree(
                List(Inline),
                Default,
                memberName,
                Nil,
                Nil,
                MemberImplCustom(s"this.cast(${TsExpr.format(expr)})"),
                tpe,
                isOverride = false,
                memberCs,
                importedCodePath + memberName,
              )
          }
          ModuleTree(Nil, name, Nil, cast +: newMembers, NoComments, importedCodePath)
        }

        if (isWithinScalaModule) List(ta) else List(ta, module)

      /* Any other enum? a type and an object */
      case TsDeclEnum(cs, _, _, importName(name), members, isValue, exportedFrom, _, codePath) =>
        val importedCodePath = importName(codePath)

        val baseInterface: TypeRef =
          ImportType(Wildcards.No, scope, importName)(
            TsTypeRef(NoComments, exportedFrom.fold(codePath.forceHasPath.codePath)(_.name), Nil),
          )

        val underlying = underlyingType(e)

        val typeTree: Tree =
          exportedFrom match {
            case Some(ef) =>
              scalajs.TypeAliasTree(
                name     = name,
                tparams  = Nil,
                alias    = ImportType(Wildcards.No, scope, importName)(TsTypeRef(NoComments, ef.name, Nil)),
                comments = Comments(CommentData(Markers.IsTrivial)),
                codePath = importedCodePath,
              )
            case None =>
              ClassTree(
                annotations = Seq(JsNative),
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
              val applyParam = ParamTree(Name.value, underlying, None, NoComments)
              Some(
                MethodTree(
                  annotations = Annotation.method(name, isBracketAccess = true),
                  level       = Default,
                  name        = Name.APPLY,
                  tparams     = Nil,
                  params      = Seq(Seq(applyParam)),
                  impl        = MemberImplNative,
                  resultType  = TypeRef.Intersection(baseInterface :: underlying :: Nil).withOptional(true),
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = importedCodePath + Name.APPLY,
                ),
              )
            } else None

          val membersSyms: Seq[Tree] =
            members flatMap {
              case TsEnumMember(memberCs, importName(memberName), exprOpt) =>
                val memberType: Option[ClassTree] =
                  if (exportedFrom.nonEmpty) None
                  else
                    Some(
                      ClassTree(
                        annotations = Seq(JsNative),
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

                val memberValue: Option[FieldTree] =
                  if (isValue) {
                    Some(
                      FieldTree(
                        annotations = Nil,
                        name        = memberName,
                        tpe         = TypeRef.Intersection(memberTypeRef :: underlying :: Nil),
                        impl        = MemberImplNative,
                        isReadOnly  = true,
                        isOverride  = false,
                        comments =
                          exprOpt.fold(Comments(Nil))(expr => Comments(Comment(s"/* ${TsExpr.format(expr)} */ "))),
                        codePath = importedCodePath + memberName,
                      ),
                    )
                  } else None

                Seq() ++ memberType ++ memberValue
            }

          ModuleTree(
            anns,
            name,
            parents  = Nil,
            members  = membersSyms ++ applyMethod,
            comments = cs,
            codePath = importedCodePath,
          )
        }

        Seq(moduleTree, typeTree)
    }
}
