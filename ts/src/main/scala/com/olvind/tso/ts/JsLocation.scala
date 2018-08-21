package com.olvind.tso
package ts

trait HasJsLocation {
  def jsLocation: JsLocation
  def withJsLocation(newLocation: JsLocation): HasJsLocation
}

sealed trait JsLocation {
  def /(tree: TsTree): JsLocation
  def isTopLevel: Boolean
}

sealed trait ModuleSpec {
  def specifyMore(tsIdent: TsIdent): ModuleSpec.Specified =
    this match {
      case ModuleSpec.Defaulted     => ModuleSpec.Specified(Seq(tsIdent))
      case ModuleSpec.Namespaced    => ModuleSpec.Specified(Seq(tsIdent))
      case ModuleSpec.Specified(is) => ModuleSpec.Specified(is :+ tsIdent)
    }
}

object ModuleSpec {
  case object Defaulted  extends ModuleSpec
  case object Namespaced extends ModuleSpec
  final case class Specified(tsIdents: Seq[TsIdent]) extends ModuleSpec
}

object JsLocation {
  case object Zero extends JsLocation {
    override def /(tree: TsTree): JsLocation = Zero
    override def isTopLevel: Boolean = true
  }

  case class Global(jsPath: TsQIdent) extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      tree match {
        case x: TsDeclModule => x.jsLocation
        case x: TsNamedDecl  => Global(jsPath + x.name)
        case _: TsGlobal     => Global(TsQIdent.empty)
        case _ => this
      }
    override def isTopLevel: Boolean =
      jsPath === TsQIdent.empty
  }

  case class Module private (module: TsIdentModule, spec: ModuleSpec) extends JsLocation {
    override def /(tree: TsTree): JsLocation =
      tree match {
        case x: TsDeclModule => x.jsLocation
        case x: TsNamedDecl  => Module(module, spec.specifyMore(x.name))
        case _ => this
      }

    override def isTopLevel: Boolean =
      spec === ModuleSpec.Defaulted || spec === ModuleSpec.Namespaced
  }
}
