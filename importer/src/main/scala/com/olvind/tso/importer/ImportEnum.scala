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

  def apply(e: TsDeclEnum, anns: Seq[ClassAnnotation], scope: TreeScope): Seq[Symbol] = {
    val TsDeclEnum(cs, _, ImportName(name), members, isValue, exportedFrom, _, codePath) = e

    val baseInterface: TypeRef =
      ImportType(Wildcards.No, scope)(TsTypeRef(exportedFrom.fold(codePath.forceHasPath.codePath)(_.name), Nil))

    val underlying = underlyingType(e)

    val typeSymbol: Symbol =
      exportedFrom match {
        case Some(ef) =>
          scalajs.TypeAliasSymbol(
            name     = name,
            tparams  = Nil,
            alias    = ImportType(Wildcards.No, scope)(TsTypeRef(ef.name, Nil)),
            comments = NoComments
          )
        case None =>
          ClassSymbol(
            annotations = Seq(JsNative),
            name        = name,
            tparams     = Nil,
            parents     = Nil,
            ctors       = Nil,
            members     = Nil,
            classType   = ClassType.Trait,
            isSealed    = true,
            comments    = NoComments
          )
      }

    val moduleSymbol: ModuleSymbol = {
      val applyMethod: Option[MethodSymbol] =
        if (isValue) {
          val applyParam = ParamSymbol(Name.value, underlying, NoComments)
          Some(
            MethodSymbol(
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

      val membersSyms: Seq[Symbol] =
        members flatMap {
          case TsEnumMember(memberCs, ImportName(memberName), literalOpt) =>
            val memberType: Option[ClassSymbol] =
              if (exportedFrom.nonEmpty) None
              else
                Some(
                  ClassSymbol(
                    annotations = Seq(JsNative),
                    name        = memberName,
                    tparams     = Nil,
                    parents     = Seq(baseInterface),
                    ctors       = Nil,
                    members     = Nil,
                    classType   = ClassType.Trait,
                    isSealed    = true,
                    comments    = memberCs
                  )
                )

            val memberComments = Comments(literalOpt map {
              case Left(x)  => Comment(s"/* ${x.literal} */ ")
              case Right(x) => Comment(s"/* ${x.value} */ ")
            })
            val memberTypeRef = baseInterface.copy(typeName = baseInterface.typeName + memberName)

            val memberValue: Option[FieldSymbol] =
              if (isValue) {
                Some(
                  FieldSymbol(
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

      ModuleSymbol(anns, name, ModuleTypeNative, parents = Nil, members = membersSyms ++ applyMethod, comments = cs)
    }

    Seq(moduleSymbol, typeSymbol)
  }
}
