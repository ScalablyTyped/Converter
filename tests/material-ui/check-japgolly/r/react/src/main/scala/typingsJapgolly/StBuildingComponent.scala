package typingsJapgolly

import japgolly.scalajs.react.Key
import japgolly.scalajs.react.Ref.Simple
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StBuildingComponent[R <: js.Object] extends Any {
  @scala.inline
  def args: js.Array[js.Any]
  @scala.inline
  def set(key: String, value: js.Any): this.type = {
    args(1).asInstanceOf[js.Dynamic].updateDynamic(key)(value)
    this
  }
  @scala.inline
  def withComponent(f: js.Any => js.Any): this.type = {
    args.update(0, f(args(0)))
    this
  }
  @scala.inline
  def apply(mods: VdomNode*): this.type = {
    mods.foreach((mod: VdomNode) => args.push(mod.rawNode.asInstanceOf[js.Any]))
    this
  }
  @scala.inline
  def withKey(key: Key): this.type = set("key", key.asInstanceOf[js.Any])
  @scala.inline
  def withRef(ref: R => Unit): this.type = set("ref", ref)
  @scala.inline
  def withRef(ref: Simple[R]): this.type = set("ref", ref.rawSetFn)
}

object StBuildingComponent {
  @JSImport("react", JSImport.Namespace, "React")
  @js.native
  object ReactRaw
    extends js.Object {
    val createElement: js.Dynamic = js.native
  }
  
  @scala.inline
  implicit def make(comp: StBuildingComponent[_]): VdomElement = {
    if (!scala.scalajs.runtime.linkingInfo.productionMode) {
      if (comp.args(0) == null) throw new IllegalStateException("This component has already been built into a ReactElement, and cannot be reused")
  }
    val ret = (ReactRaw.createElement.applyDynamic("apply")(ReactRaw, comp.args)).asInstanceOf[Element]
    if (!scala.scalajs.runtime.linkingInfo.productionMode) {
      comp.args.update(0, null)
  }
    VdomElement(ret)
  }
  class Default[R <: js.Object] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[R]
  
}

