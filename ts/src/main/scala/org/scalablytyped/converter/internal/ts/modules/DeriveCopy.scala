package org.scalablytyped.converter.internal
package ts
package modules

import org.scalablytyped.converter.internal.ts.transforms.SetCodePath

object DeriveCopy {
  def apply(x: TsNamedDecl, ownerCp: CodePath, _rename: Option[TsIdentSimple]): IArray[TsNamedDecl] = {
    val rename = _rename.filter(r => x.name =/= r) // I think this only happens with `default`, but as might as well make sure

    //keep as def, we need to let `TsDeclNamespace` through without a codePath as it might be synthetic
    def origin = x.codePath.forceHasPath.codePath

    def codePathFor(name: TsIdent) = ownerCp match {
      case CodePath.NoPath => x.codePath
      case hasPath: CodePath.HasPath => hasPath + name
    }

    (x, x.name, x.codePath, ownerCp) match {
      case (x, _, xCp: CodePath.HasPath, ownerCp: CodePath.HasPath)
          if xCp.codePath.parts.length === ownerCp.codePath.parts.length + 1 &&
            xCp.codePath.parts.startsWith(ownerCp.codePath.parts) &&
            rename.isEmpty =>
        IArray(x)

      case (x: TsDeclModule, _, _, ownerCp) if rename.isDefined =>
        IArray(updatedContainer(ownerCp, x.withName(rename.get)))
      case (x: TsDeclModule, _, _, ownerCp) =>
        IArray(updatedContainer(ownerCp, x))

      case (x: TsAugmentedModule, _, _, ownerCp) if rename.isEmpty =>
        IArray(updatedContainer(ownerCp, x))
      case (_: TsAugmentedModule, _, _, _) =>
        Empty

      case (x, origName: TsIdentSimple, _, ownerCp) =>
        val name = rename.getOrElse(origName)

        val derived = x match {
          // these are synthetic, and should be re-expanded downstream
          case _: TsDeclClass if x.comments.has[Marker.ExpandedClass.type] =>
            IArray.Empty

          case x: TsDeclClass =>
            IArray(
              x.copy(
                name = name,
                members = x.members.collect {
                  case c: TsMemberCtor => c
                  case c @ TsMemberFunction(_, _, TsIdent.constructor, _, _, _, _) => c
                  case x: TsMemberProperty if x.isStatic => x
                  case x: TsMemberFunction if x.isStatic => x
                },
                declared   = true,
                implements = Empty,
                parent     = Some(TsTypeRef(NoComments, origin, TsTypeParam.asTypeArgs(x.tparams))),
                codePath   = codePathFor(name),
              ),
            )

          case x: TsDeclInterface =>
            IArray(
              TsDeclTypeAlias(
                comments = Comments(Marker.IsTrivial),
                declared = true,
                name     = name,
                tparams  = x.tparams,
                alias    = TsTypeRef(NoComments, origin, TsTypeParam.asTypeArgs(x.tparams)),
                codePath = codePathFor(name),
              ),
            )

          case x: TsDeclEnum =>
            IArray(
              x.copy(
                name         = name,
                isValue      = true,
                exportedFrom = x.exportedFrom.orElse(Some(TsTypeRef(NoComments, origin, Empty))),
                codePath     = codePathFor(name),
              ),
            )

          case x: TsDeclVar =>
            IArray(x.copy(name = name, codePath = codePathFor(name)))

          case x: TsDeclFunction =>
            IArray(x.copy(name = name, codePath = codePathFor(name)))

          case x: TsDeclNamespace =>
            IArray(updatedContainer(ownerCp, x.copy(name = name, codePath = codePathFor(name))))

          case x: TsDeclTypeAlias =>
            IArray(
              TsDeclTypeAlias(
                Comments(Marker.IsTrivial),
                declared = false,
                name,
                x.tparams,
                TsTypeRef(NoComments, origin, TsTypeParam.asTypeArgs(x.tparams)),
                codePathFor(name),
              ),
            )
        }

        derived
      case other =>
        sys.error(s"Unexpected: ${other.toString().take(200)}")
    }
  }

  def updatedContainer(ownerCp: CodePath, x: TsContainer with TsNamedDecl): TsNamedDecl = {
    def go(tree: TsContainerOrDecl): IArray[TsContainerOrDecl] =
      tree match {
        case m: TsNamedDecl => apply(m, x.codePath, None)
        case g: TsGlobal =>
          val newMembers = g.members.flatMap(go)
          IArray(g.copy(members = newMembers))
        case other => IArray(other)
      }

    /* For this to be correct we convert nested members with old codePath, then recursively update it afterwards */
    val newMembers: IArray[TsContainerOrDecl] =
      x.members.flatMap(go)

    (ownerCp, x.withMembers(newMembers)) match {
      case (p: CodePath.HasPath, xx: TsNamedDecl) =>
        SetCodePath.visitTsNamedDecl(p)(xx)
      case (CodePath.NoPath, xx: TsNamedDecl) =>
        xx
      case wrong => sys.error(s"Unexpected $wrong")
    }
  }
}
