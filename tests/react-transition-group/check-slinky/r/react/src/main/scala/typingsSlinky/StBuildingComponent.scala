package typingsSlinky

import slinky.core.AttrPair
import slinky.core.OptionalAttrPair
import slinky.core.TagMod
import slinky.core.facade.ReactElement
import slinky.core.facade.ReactRef
import typingsSlinky.StBuildingComponent.make
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
  
  /* You typically shouldnt call this yourself, but it can be useful if you're for instance mapping a sequence and you need types to infer properly */
  @scala.inline
  def build: ReactElement = make(this)
  
  @scala.inline
  def unsafeSpread(obj: js.Any): this.type = {
    js.Object.assign(args(1).asInstanceOf[js.Object], obj.asInstanceOf[js.Object])
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
  implicit def make[E, R <: js.Object](comp: StBuildingComponent[_, _]): ReactElement = {
    if (!scala.scalajs.runtime.linkingInfo.productionMode) {
    if (comp.args(0) == null) throw new IllegalStateException("This component has already been built into a ReactElement, and cannot be reused")
  }
    val ret = (ReactRaw.createElement.applyDynamic("apply")(ReactRaw, comp.args)).asInstanceOf[ReactElement]
    if (!scala.scalajs.runtime.linkingInfo.productionMode) {
    comp.args.update(0, null)
  }
    ret
  }
  
  class Default[E, R <: js.Object] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[E, R]
}
