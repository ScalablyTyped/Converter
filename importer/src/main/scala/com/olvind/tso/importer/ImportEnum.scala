package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.ts._

object ImportEnum {
  def underlyingType(e: TsDeclEnum): TypeRef =
    e.members
      .collectFirst {
        case TsEnumMember(_, _, Some(Left(lit))) =>
          lit match {
            case _: TsLiteralString  => TypeRef.String
            case _: TsLiteralNumber  => TypeRef.Double
            case _: TsLiteralBoolean => TypeRef.Boolean
          }
      }
      .getOrElse(TypeRef.String)

  def apply(e: TsDeclEnum, anns: Seq[ClassAnnotation], scope: TsTreeScope, importName: ImportName): Seq[Tree] = {
    val TsDeclEnum(cs, _, importName(name), members, isValue, exportedFrom, _, codePath: CodePath.HasPath) = e
    val importedCodePath = importName(codePath.codePath)

    val baseInterface: TypeRef =
      ImportType(Wildcards.No, scope, importName)(
        TsTypeRef(NoComments, exportedFrom.fold(codePath.codePath)(_.name), Nil)
      )

    val underlying = underlyingType(e)

    val typeTree: Tree =
      exportedFrom match {
        case Some(ef) =>
          scalajs.TypeAliasTree(
            name     = name,
            tparams  = Nil,
            alias    = ImportType(Wildcards.No, scope, importName)(TsTypeRef(NoComments, ef.name, Nil)),
            comments = NoComments,
            codePath = importedCodePath
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
            codePath    = importedCodePath
          )
      }

    val moduleTree: ModuleTree = {
      val applyMethod: Option[MethodTree] =
        if (isValue) {
          val applyParam = ParamTree(Name.value, underlying, NoComments)
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
              comments    = NoComments
            )
          )
        } else None

      val membersSyms: Seq[Tree] =
        members flatMap {
          case TsEnumMember(memberCs, importName(memberName), literalOpt) =>
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
                    codePath    = importedCodePath + memberName
                  )
                )

            val memberComments = Comments(literalOpt map {
              case Left(x)  => Comment(s"/* ${x.literal} */")
              case Right(x) => Comment(s"/* ${x.value} */")
            })
            val memberTypeRef = baseInterface.copy(typeName = baseInterface.typeName + memberName)

            val memberValue: Option[FieldTree] =
              if (isValue) {
                Some(
                  FieldTree(
                    annotations = Nil,
                    name        = memberName,
                    impl        = MemberImplNative,
                    tpe         = TypeRef.Intersection(memberTypeRef :: underlying :: Nil),
                    comments    = memberComments,
                    isReadOnly  = true,
                    isOverride  = false
                  )
                )
              } else None

            Seq() ++ memberType ++ memberValue
        }

      ModuleTree(anns,
                 name,
                 ModuleTypeNative,
                 parents  = Nil,
                 members  = membersSyms ++ applyMethod,
                 comments = cs,
                 codePath = importedCodePath)
    }

    Seq(moduleTree, typeTree)
  }
}
