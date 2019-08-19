package com.olvind.tso
package ts

trait HasJsLocation {
  def jsLocation: JsLocation
  def withJsLocation(newLocation: JsLocation): HasJsLocation
}

sealed trait JsLocation {
  def /(tree: TsTree): JsLocation

  def +(tsIdent: TsIdent): JsLocation =
    this match {
      case JsLocation.Zero              => JsLocation.Zero
      case JsLocation.Module(mod, spec) => JsLocation.Module(mod, spec + tsIdent)
      case JsLocation.Global(jsPath)    => JsLocation.Global(jsPath ++ List(tsIdent))
    }
}

sealed trait ModuleSpec {
  def +(tsIdent: TsIdent): ModuleSpec.Specified =
    this match {
      case ModuleSpec.Defaulted     => ModuleSpec.Specified(Seq(tsIdent))
      case ModuleSpec.Namespaced    => ModuleSpec.Specified(Seq(tsIdent))
      case ModuleSpec.Specified(is) => ModuleSpec.Specified(is :+ tsIdent)
    }
}

object ModuleSpec {
  case object Defaulted extends ModuleSpec
  case object Namespaced extends ModuleSpec
  final case class Specified(tsIdents: Seq[TsIdent]) extends ModuleSpec
}

object JsLocation {
  case object Zero extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      tree match {
        case x: TsDeclModule => Module(x.name, ModuleSpec.Namespaced)
        case x: TsNamedDecl  => Global(TsQIdent(List(x.name)))
        case _: TsGlobal     => Zero
        case _ => this
      }
  }

  case class Global(jsPath: TsQIdent) extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      tree match {
        case x: TsDeclModule => Module(x.name, ModuleSpec.Namespaced)
        case x: TsNamedDecl  => Global(jsPath + x.name)
        case _: TsGlobal     => Zero
        case _ => this
      }
  }

  case class Module private (module: TsIdentModule, spec: ModuleSpec) extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      tree match {
        case x: TsDeclModule => x.jsLocation
        case x: TsNamedDecl  => Module(module, spec + x.name)
        case _ => this
      }
  }
}
