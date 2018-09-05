package com.olvind.tso
package ts.modules

import com.olvind.tso.ts._

object DeriveCopy {
  def apply(x: TsNamedDecl, rename: Option[TsIdent]): Seq[TsNamedDecl] = {
    //keep as def, we need to let `TsDeclNamespace` through without a codePath as it might be synthetic
    def origin = x.codePath.forceHasPath.codePath

    x match {
      case x: TsDeclClass =>
        val `class` = x.copy(
          name = rename getOrElse x.name,
          members = x.members.collect {
            case c: TsMemberCtor => c
            case c @ TsMemberFunction(_, _, TsIdent.constructor, _, _, _, _) => c
            case x: TsMemberProperty if x.isStatic => x
            case x: TsMemberFunction if x.isStatic => x
          },
          declared = true,
          implements = Nil,
          parent = Some(TsTypeRef(origin, TsTypeParam.asTypeArgs(x.tparams)))
        )

        List(`class`)

      case x: TsDeclInterface =>
        List(
          TsDeclTypeAlias(
            comments = NoComments,
            declared = true,
            name = rename getOrElse x.name,
            tparams = x.tparams,
            alias = TsTypeRef(origin, TsTypeParam.asTypeArgs(x.tparams)),
            codePath = x.codePath
          )
        )

      case x: TsDeclEnum =>
        List(
          TsDeclTypeAlias(
            comments = NoComments,
            declared = true,
            name = rename getOrElse x.name,
            tparams = Nil,
            alias = TsTypeRef(origin, Nil),
            codePath = x.codePath
          )
        )

      case x: TsDeclVar =>
        List(x.copy(name = rename getOrElse x.name))

      case x: TsDeclFunction =>
        List(x.copy(name = rename getOrElse x.name))

      case x: TsDeclNamespace =>
        val newMembers = x.members.flatMap {
          case m: TsNamedDecl => apply(m, None)
          case other => Seq(other)
        }
        val name = rename match {
          case Some(renamed) => TsIdentNamespace(renamed.value)
          case None          => x.name
        }
        List(x.copy(name = name, members = newMembers))

      case x: TsDeclModule =>
        val newMembers = x.members.flatMap {
          case m: TsNamedDecl => apply(m, None)
          case other => Seq(other)
        }

        val name = rename match {
          case Some(renamed) => TsIdentNamespace(renamed.value)
          case None          => TsIdentNamespace(x.name.value)
        }

        List(
          TsDeclNamespace(
            x.comments,
            false,
            name,
            newMembers,
            x.codePath,
            x.jsLocation
          )
        )

      case x: TsAugmentedModule =>
        val newMembers = x.members.collect { case m: TsNamedDecl => apply(m, None) }.flatten
        val name = rename match {
          case Some(renamed) => TsIdentModule(None, renamed.value.split("/").toList)
          case None          => x.name
        }
        List(x.copy(name = name, members = newMembers))

      case x: TsDeclTypeAlias =>
        List(
          TsDeclTypeAlias(NoComments,
                          declared = false,
                          rename getOrElse x.name,
                          x.tparams,
                          TsTypeRef(x.codePath.forceHasPath.codePath, TsTypeParam.asTypeArgs(x.tparams)),
                          x.codePath)
        )
    }
  }

  def downgradeClass(x: TsDeclClass): TsDeclInterface = {
    val nonStatics: Seq[TsMember] =
      x.members filterNot {
        case _:  TsMemberCtor     => true
        case xx: TsMemberProperty => xx.isStatic
        case xx: TsMemberFunction => xx.isStatic || xx.name === TsIdent.constructor
        case _ => false
      }

    TsDeclInterface(x.comments, x.declared, x.name, x.tparams, x.parent.to[Seq] ++ x.implements, nonStatics, x.codePath)
  }

  def downgrade(x: TsContainerOrDecl): Option[TsContainerOrDecl] = x match {
    case e @ TsExport(_, _, TsExporteeTree(decl)) =>
      downgrade(decl) flatMap {
        case d: TsNamedDecl => Some(e.copy(exported = TsExporteeTree(d)))
        case _ => Some(e)
      }
    case _: TsDeclVar | _: TsDeclFunction => None
    case cls: TsDeclClass =>
      Some(downgradeClass(cls))
    case x: TsDeclNamespace =>
      Some(x.copy(members = x.members flatMap downgrade))
    case x: TsDeclEnum =>
      val tpe: TsTypeRef =
        x.members
          .collectFirst {
            case TsEnumMember(_, _, Some(Left(lit))) =>
              lit match {
                case TsLiteralNumber(_)  => TsTypeRef.number
                case TsLiteralBoolean(_) => TsTypeRef.boolean
                case TsLiteralString(_)  => TsTypeRef.string
              }
          }
          .getOrElse(TsTypeRef.any)

      Some(TsDeclTypeAlias(NoComments, declared = false, x.name, Nil, tpe, x.codePath))

    case other => Some(other)
  }
}
