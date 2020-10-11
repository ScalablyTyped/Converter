package org.scalablytyped.converter.internal
package ts
package modules

object KeepTypesOnly {
  def apply(x: TsContainerOrDecl): Option[TsContainerOrDecl] =
    x match {
      case e @ TsExport(_, _, _, TsExporteeTree(decl)) =>
        apply(decl).flatMap {
          case d: TsNamedDecl => Some(e.copy(exported = TsExporteeTree(d)))
          case _ => Some(e)
        }
      case x: TsNamedDecl => named(x)
      case other => Some(other)
    }

  def named(x: TsNamedDecl): Option[TsNamedDecl] = x match {
    case _: TsDeclVar | _: TsDeclFunction => None
    case cls @ TsDeclClass(comments, declared, _, name, tparams, _, _, members, _, _) =>
      val nonStatics = members.filterNot(TsMember.isStaticOrCtor)

      Some(
        TsDeclInterface(
          comments,
          declared,
          name,
          tparams,
          cls.inheritance,
          nonStatics,
          x.codePath,
        ),
      )

    case x: TsDeclNamespace   => Some(x.copy(members = x.members.mapNotNone(apply)))
    case x: TsAugmentedModule => Some(x.copy(members = x.members.mapNotNone(apply)))
    case x: TsDeclEnum        => Some(x.copy(isValue = false))
    case other => Some(other)
  }
}
