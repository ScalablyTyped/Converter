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
          case _: TsLiteral.Str  => TypeRef.String
          case _: TsLiteral.Num  => TypeRef.Double
          case _: TsLiteral.Bool => TypeRef.Boolean
        }
    }
    TypeRef.Union(found, NoComments, sort = true)
  }

  def apply(
      e:            TsDeclEnum,
      anns:         IArray[Annotation],
      scope:        TsTreeScope,
      importName:   AdaptiveNamingImport,
      importType:   ImportType,
      illegalNames: CleanIllegalNames,
      importExpr:   ImportExpr,
  ): IArray[Tree] =
    e match {
      /* exported const enum? type alias */
      case TsDeclEnum(cs, _, true, _, _, _, Some(exportedFrom), _, codePath) =>
        val tpe        = importType(scope, importName)(exportedFrom)
        val importedCp = importName(codePath)
        IArray(
          TypeAliasTree(importedCp.parts.last, ProtectionLevel.Public, Empty, tpe, cs + Marker.IsTrivial, importedCp),
        )

      /* normal const enum? type alias. And output a scala object with values if possible, otherwise a comment */
      case TsDeclEnum(cs, _, true, _, members, _, None, _, codePath) =>
        val importedCodePath = importName(codePath)
        val ta = TypeAliasTree(
          name     = importedCodePath.parts.last,
          level    = ProtectionLevel.Public,
          tparams  = Empty,
          alias    = importType(scope, importName)(TsTypeUnion(e.members.map(m => TsExpr.typeOfOpt(m.expr)))),
          comments = cs,
          codePath = importedCodePath,
        )

        def module = {
          val newMembers = members
            .map {
              case TsEnumMember(memberCs, ImportName(memberName), exprOpt) =>
                val expr            = exprOpt.getOrElse(sys.error("Expression cannot be empty here"))
                val tpe             = importType(scope, importName)(TsExpr.typeOf(expr))
                val memberNameFixed = if (illegalNames.Illegal(memberName)) memberName.withSuffix("") else memberName

                MethodTree(
                  IArray(Annotation.Inline),
                  ProtectionLevel.Public,
                  memberNameFixed,
                  Empty,
                  Empty,
                  ExprTree.AsInstanceOf(importExpr(expr, scope, ImportType.ShouldWiden.No), tpe),
                  tpe,
                  isOverride = false,
                  memberCs,
                  importedCodePath + memberNameFixed,
                  isImplicit = false,
                )
            }
            .distinctBy(_.name.unescaped)

          /* keep module members when minimizing */
          val related = Comments(Marker.MinimizationRelated(newMembers.map(m => TypeRef(m.codePath))))
          ModuleTree(
            Empty,
            ProtectionLevel.Public,
            importedCodePath.parts.last,
            Empty,
            newMembers,
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
          importType(scope, importName)(
            TsTypeRef(NoComments, exportedFrom.fold(codePath.forceHasPath.codePath)(_.name), Empty),
          )

        val underlying = underlyingType(e)

        val typeTree: Tree =
          exportedFrom match {
            case Some(ef) =>
              TypeAliasTree(
                name     = enumName,
                level    = ProtectionLevel.Public,
                tparams  = Empty,
                alias    = importType(scope, importName)(TsTypeRef(NoComments, ef.name, Empty)),
                comments = Comments(Marker.IsTrivial),
                codePath = importedCodePath,
              )
            case None =>
              ClassTree(
                isImplicit  = false,
                annotations = IArray(Annotation.JsNative),
                level       = ProtectionLevel.Public,
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
              val applyParam =
                ParamTree(Name.value, isImplicit = false, isVal = false, underlying, NotImplemented, NoComments)
              Some(
                MethodTree(
                  annotations = IArray(Annotation.JsBracketAccess),
                  level       = ProtectionLevel.Public,
                  name        = Name.APPLY,
                  tparams     = Empty,
                  params      = IArray(IArray(applyParam)),
                  impl        = ExprTree.native,
                  resultType  = TypeRef.Intersection(IArray(baseInterface, underlying), NoComments).withOptional(true),
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = importedCodePath + Name.APPLY,
                  isImplicit  = false,
                ),
              )
            } else None

          val membersSyms: IArray[Tree] =
            members.flatMap {
              case TsEnumMember(memberCs, ImportName(memberName), exprOpt) =>
                val memberType: Option[ClassTree] =
                  if (exportedFrom.nonEmpty) None
                  else
                    Some(
                      ClassTree(
                        isImplicit  = false,
                        annotations = IArray(Annotation.JsNative),
                        level       = ProtectionLevel.Public,
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
                      if (illegalNames.Illegal(memberName) || ScalaJsClasses.jsObjectMembersByName.contains(memberName))
                        (IArray(Annotation.JsName(memberName)), memberName.withSuffix(""))
                      else (Empty, memberName)

                    val comments =
                      exprOpt.fold(Comments(Nil))(expr => Comments(Comment(s"/* ${TsExpr.format(expr)} */ ")))

                    Some(
                      FieldTree(
                        annotations = anns,
                        level       = ProtectionLevel.Public,
                        name        = name,
                        tpe         = TypeRef.Intersection(IArray(memberTypeRef, underlying), NoComments),
                        impl        = ExprTree.native,
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
            annotations = anns,
            level       = ProtectionLevel.Public,
            name        = enumName,
            parents     = Empty,
            members     = membersSyms ++ IArray.fromOption(applyMethod),
            comments    = cs + Marker.EnumObject,
            codePath    = importedCodePath,
            isOverride  = false,
          )
        }

        IArray(moduleTree, typeTree)
    }
}
