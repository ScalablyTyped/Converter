package org.scalablytyped.converter.internal
package ts

trait HasJsLocation {
  def jsLocation: JsLocation
  def withJsLocation(newLocation: JsLocation): HasJsLocation
}

sealed trait JsLocation {
  def /(tree: TsTree): JsLocation

  def +(tsIdent: TsIdent): JsLocation =
    if (tsIdent === TsIdent.namespaced) this
    else
      this match {
        case JsLocation.Zero              => JsLocation.Zero
        case JsLocation.Module(mod, spec) => JsLocation.Module(mod, spec + tsIdent)
        case JsLocation.Global(jsPath)    => JsLocation.Global(jsPath + tsIdent)
        case JsLocation.Both(mod, global) =>
          JsLocation.Both(
            (mod + tsIdent).asInstanceOf[JsLocation.Module],
            (global + tsIdent).asInstanceOf[JsLocation.Global],
          )
      }
}

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

object JsLocation {
  case object Zero extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      tree match {
        case x: TsDeclModule                                 => Module(x.name, ModuleSpec.Namespaced)
        case x: TsAugmentedModule                            => Module(x.name, ModuleSpec.Namespaced)
        case x: TsNamedDecl if x.name =/= TsIdent.namespaced => Global(TsQIdent.of(x.name))
        case _: TsGlobal                                     => Zero
        case _ => this
      }
  }

  case class Global(jsPath: TsQIdent) extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      tree match {
        case x: TsDeclModule                                 => Module(x.name, ModuleSpec.Namespaced)
        case x: TsAugmentedModule                            => Module(x.name, ModuleSpec.Namespaced)
        case x: TsNamedDecl if x.name =/= TsIdent.namespaced => Global(jsPath + x.name)
        case _: TsGlobal                                     => Zero
        case _ => this
      }
  }

  case class Module private (module: TsIdentModule, spec: ModuleSpec) extends JsLocation {
    override def /(tree: TsTree): Module =
      tree match {
        case x: TsDeclModule      => Module(x.name, ModuleSpec.Namespaced)
        case x: TsAugmentedModule => Module(x.name, ModuleSpec.Namespaced)
        case x: TsNamedDecl       => Module(module, spec + x.name)
        case _ => this
      }
  }

  case class Both private (module: Module, global: Global) extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      global / tree match {
        case g: Global => Both(module / tree, g)
        case other => other
      }
  }
}
