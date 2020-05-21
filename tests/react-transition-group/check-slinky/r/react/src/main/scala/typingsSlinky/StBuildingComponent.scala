package typingsSlinky

import slinky.core.AttrPair
import slinky.core.OptionalAttrPair
import slinky.core.TagMod
import slinky.core.facade.ReactElement
import slinky.core.facade.ReactRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StBuildingComponent[E, R <: js.Object] extends Any {
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
  def apply(mods: TagMod[E]*): this.type = {
    mods.foreach((mod: TagMod[E]) => if (mod.isInstanceOf[AttrPair[_]]) {
      val a = mod.asInstanceOf[AttrPair[_]]
      set(a.name, a.value)
  } else if (mod.isInstanceOf[OptionalAttrPair[_]]) {
      val o = mod.asInstanceOf[OptionalAttrPair[_]]
      if (o.value.isDefined) set(o.name, o.value.get)
  } else args.push(mod))
    this
  }
  @scala.inline
  def withKey(key: String): this.type = set("key", key)
  @scala.inline
  def withRef(ref: R => Unit): this.type = set("ref", ref)
  @scala.inline
  def withRef(ref: ReactRef[R]): this.type = set("ref", ref)
}

object StBuildingComponent {
  @JSImport("react", JSImport.Namespace, "React")
  @js.native
  object ReactRaw
    extends js.Object {
    val createElement: js.Dynamic = js.native
  }
  
  @scala.inline
  implicit def make[E, R <: js.Object](comp: StBuildingComponent[E, R]): ReactElement = {
    if (comp.args(0) == null) throw new IllegalStateException("This component has already been built into a ReactElement, and cannot be reused")
    val ret = (ReactRaw.createElement.applyDynamic("apply")(ReactRaw, comp.args)).asInstanceOf[ReactElement]
    comp.args.update(0, null)
    ret
  }
  class Default[E, R <: js.Object] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[E, R]
  
}

