package com.olvind.tso
package ts
package modules

import com.olvind.tso.ts.CodePath.{HasPath, NoPath}
import com.olvind.tso.ts.transforms.SetCodePath

object DeriveCopy {
  def apply(x: TsNamedDecl, ownerCp: CodePath, _rename: Option[TsIdent]): Seq[TsNamedDecl] = {
    val rename = _rename.filter(_ =/= x.name) // I think this only happens with `default`, but as might as well make sure

    //keep as def, we need to let `TsDeclNamespace` through without a codePath as it might be synthetic
    def origin = x.codePath.forceHasPath.codePath

    (x, x.codePath, ownerCp) match {
      case (x: TsDeclFunction, _, ownerCodePath: CodePath.HasPath) =>
        List(SetCodePath.visitTsDeclFunction(ownerCodePath)(rename.foldLeft(x)(_ withName _)))

      case (x: TsDeclVar, _, ownerCodePath: CodePath.HasPath) =>
        List(SetCodePath.visitTsDeclVar(ownerCodePath)(rename.foldLeft(x)(_ withName _)))

      case (x, xCp: HasPath, ownerCp: HasPath)
          if xCp.codePath.parts.length === ownerCp.codePath.parts.length + 1 &&
            xCp.codePath.parts.startsWith(ownerCp.codePath.parts) &&
            rename.isEmpty =>
        List(x)

      case (x, _, ownerCp) =>
        val name = rename getOrElse x.name

        val codePath = ownerCp match {
          case NoPath => x.codePath
          case hasPath: HasPath => hasPath / name
        }

        val derived = List(x) collect {
          case x: TsDeclClass =>
            x.copy(
              name = name,
              members = x.members.collect {
                case c: TsMemberCtor => c
                case c @ TsMemberFunction(_, _, TsIdent.constructor, _, _, _, _) => c
                case x: TsMemberProperty if x.isStatic => x
                case x: TsMemberFunction if x.isStatic => x
              },
              declared   = true,
              implements = Nil,
              parent     = Some(TsTypeRef(NoComments, origin, TsTypeParam.asTypeArgs(x.tparams))),
              codePath   = codePath,
            )

          case x: TsDeclInterface =>
            TsDeclTypeAlias(
              comments = Comments(CommentData(Markers.IsTrivial)),
              declared = true,
              name     = name,
              tparams  = x.tparams,
              alias    = TsTypeRef(NoComments, origin, TsTypeParam.asTypeArgs(x.tparams)),
              codePath = codePath,
            )

          case x: TsDeclEnum =>
            x.copy(
              name         = name,
              isValue      = true,
              exportedFrom = x.exportedFrom orElse Some(TsTypeRef(NoComments, origin, Nil)),
              codePath     = codePath,
            )

          case x: TsDeclVar =>
            x.copy(name = name, codePath = codePath)

          case x: TsDeclFunction =>
            x.copy(name = name, codePath = codePath)

          case x: TsDeclNamespace =>
            updatedContainer(ownerCp, x.copy(name = name, codePath = codePath))

//          case x: TsDeclModule =>
//            val asNs = TsDeclNamespace(x.comments, declared = false, name, x.members, codePath, x.jsLocation)
//            updatedContainer(ownerCp, asNs)
//
//          case x: TsAugmentedModule =>
//            val name = rename match {
//              case Some(renamed) => TsIdentModule(None, renamed.value.split("/").toList)
//              case None          => x.name
//            }
//            updatedContainer(ownerCp, x.copy(name = name, codePath = codePath))

          case x: TsDeclTypeAlias =>
            TsDeclTypeAlias(
              Comments(CommentData(Markers.IsTrivial)),
              declared = false,
              name,
              x.tparams,
              TsTypeRef(NoComments, origin, TsTypeParam.asTypeArgs(x.tparams)),
              codePath,
            )
        }

        derived
    }
  }

  def updatedContainer(ownerCp: CodePath, x: TsContainer with TsNamedDecl): TsNamedDecl = {
    /* For this to be correct we convert nested members with old codePath, then recursively update it afterwards */
    val newMembers: Seq[TsContainerOrDecl] =
      x.members.flatMap {
        case m: TsNamedDecl =>
          apply(m, x.codePath, None)
        case other => List(other)
      }

    (ownerCp, x.withMembers(newMembers)) match {
      case (p:                   HasPath, xx: TsNamedDecl) => SetCodePath.enterTsNamedDecl(p)(xx)
      case (CodePath.NoPath, xx: TsNamedDecl) => xx
      case wrong => sys.error(s"Unexpected $wrong")
    }
  }
}
