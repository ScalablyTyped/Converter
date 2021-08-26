package typingsSlinky

import slinky.core.AttrPair
import slinky.core.OptionalAttrPair
import slinky.core.TagMod
import slinky.core.facade.ReactElement
import slinky.core.facade.ReactRef
import typingsSlinky.StBuildingComponent.make
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait StBuildingComponent[E, R <: js.Object] extends Any {
  
  inline def apply(mods: TagMod[E]*): this.type = {
    mods.foreach((mod: TagMod[E]) => if (mod.isInstanceOf[AttrPair[?]]) {
    val a = mod.asInstanceOf[AttrPair[?]]
    set(a.name, a.value)
  } else if (mod.isInstanceOf[OptionalAttrPair[?]]) {
    val o = mod.asInstanceOf[OptionalAttrPair[?]]
    if (o.value.isDefined) set(o.name, o.value.get)
  } else args.push(mod))
    this
  }
  
  def args: js.Array[js.Any]
  
  /* You typically shouldnt call this yourself, but it can be useful if you're for instance mapping a sequence and you need types to infer properly */
  inline def build: ReactElement = make(this)
  
  inline def set(key: String, value: js.Any): this.type = {
    args(1).asInstanceOf[js.Dynamic].updateDynamic(key)(value)
    this
  }
  
  inline def unsafeSpread(obj: js.Any): this.type = {
    js.Object.assign(args(1).asInstanceOf[js.Object], obj.asInstanceOf[js.Object])
    this
  }
  
  inline def withComponent(f: js.Any => js.Any): this.type = {
    args.update(0, f(args(0)))
    this
  }
  
  inline def withKey(key: String): this.type = set("key", key)
  
  inline def withRef(ref: R => Unit): this.type = set("ref", ref)
  inline def withRef(ref: ReactRef[R]): this.type = set("ref", ref)
}
object StBuildingComponent {
  
  @JSImport("react", JSImport.Namespace, "React")
  @js.native
  object ReactRaw extends StObject {
    
    val createElement: js.Dynamic = js.native
  }
  
  class Default[E, R <: js.Object] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[E, R]
  
  inline implicit def make[E, R <: js.Object](comp: StBuildingComponent[E, R]): ReactElement = {
    if (!scalajs.runtime.linkingInfo.productionMode) {
    if (comp.args(0) == null) throw new IllegalStateException("This component has already been built into a ReactElement, and cannot be reused")
  }
    val ret = (ReactRaw.createElement.applyDynamic("apply")(ReactRaw, comp.args)).asInstanceOf[ReactElement]
    if (!scalajs.runtime.linkingInfo.productionMode) {
    comp.args.update(0, null)
  }
    ret
  }
}
