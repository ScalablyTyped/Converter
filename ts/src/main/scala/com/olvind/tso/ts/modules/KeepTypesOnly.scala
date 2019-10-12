package com.olvind.tso
package ts
package modules

object KeepTypesOnly {
  def apply(x: TsContainerOrDecl): Option[TsContainerOrDecl] =
    x match {
      case e @ TsExport(_, _, TsExporteeTree(decl)) =>
        apply(decl) flatMap {
          case d: TsNamedDecl => Some(e.copy(exported = TsExporteeTree(d)))
          case _ => Some(e)
        }
      case x: TsNamedDecl => named(x)
      case other => Some(other)
    }

  def named(x: TsNamedDecl): Option[TsNamedDecl] = x match {
    case _: TsDeclVar | _: TsDeclFunction => None
    case TsDeclClass(comments, declared, _, name, tparams, parent, implements, members, _, _) =>
      val nonStatics: Seq[TsMember] =
        members filterNot {
          case _:  TsMemberCtor     => true
          case xx: TsMemberProperty => xx.isStatic
          case xx: TsMemberFunction => xx.isStatic || xx.name === TsIdent.constructor
          case _ => false
        }

      Some(TsDeclInterface(comments, declared, name, tparams, parent.to[Seq] ++ implements, nonStatics, x.codePath))

    case x: TsDeclNamespace   => Some(x.copy(members = x.members flatMap apply))
    case x: TsAugmentedModule => Some(x.copy(members = x.members flatMap apply))
    case x: TsDeclEnum        => Some(x.copy(isValue = false))
    case other => Some(other)
  }
}
