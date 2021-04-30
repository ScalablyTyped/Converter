package org.scalablytyped.converter.internal
package ts

sealed trait ModuleSpec {
  def +(tsIdent: TsIdent): ModuleSpec =
    if (tsIdent === TsIdent.namespaced) this
    else
      this match {
        case ModuleSpec.Defaulted     => ModuleSpec.Specified(IArray(TsIdent.default, tsIdent))
        case ModuleSpec.Namespaced    => ModuleSpec.Specified(IArray(tsIdent))
        case ModuleSpec.Specified(is) => ModuleSpec.Specified(is :+ tsIdent)
      }
}

object ModuleSpec {
  def apply(ident: TsIdent): ModuleSpec =
    ident match {
      case TsIdent.default    => Defaulted
      case TsIdent.namespaced => Namespaced
      case other              => Specified(IArray(other))
    }

  case object Defaulted extends ModuleSpec
  case object Namespaced extends ModuleSpec
  final case class Specified(tsIdents: IArray[TsIdent]) extends ModuleSpec
}
