package typingsJapgolly

import japgolly.scalajs.react.Key
import japgolly.scalajs.react.Ref.Simple
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.TagMod
import japgolly.scalajs.react.vdom.TagMod.Composite
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.StBuildingComponent.make
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait StBuildingComponent[R <: js.Object] extends Any {
  
  @scala.inline
  def apply(mods: TagMod*): this.type = {
    mods.foreach(applyTagMod)
    this
  }
  
  @scala.inline
  def applyTagMod(t: TagMod): Unit = if (t.isInstanceOf[Composite]) {
    val tt = t.asInstanceOf[Composite]
    tt.mods.foreach(applyTagMod)
  } else if (t.isInstanceOf[VdomNode]) {
    val tt = t.asInstanceOf[VdomNode]
    args.push(tt.rawNode.asInstanceOf[js.Any])
  } else {
    val tt = t.toJs
    tt.addClassNameToProps()
    tt.addKeyToProps()
    tt.addStyleToProps()
    tt.nonEmptyChildren.foreach((children: js.Array[Node]) => args.push(children))
    tt.nonEmptyProps.foreach(unsafeSpread)
  }
  
  @scala.inline
  def args: js.Array[js.Any]
  
  /* You typically shouldnt call this yourself, but it can be useful if you're for instance mapping a sequence and you need types to infer properly */
  @scala.inline
  def build: VdomElement = make(this)
  
  @scala.inline
  def set(key: String, value: js.Any): this.type = {
    args(1).asInstanceOf[js.Dynamic].updateDynamic(key)(value)
    this
  }
  
  @scala.inline
  def unsafeSpread(obj: js.Any): this.type = {
    js.Object.assign(args(1).asInstanceOf[js.Object], obj.asInstanceOf[js.Object])
    this
  }
  
  @scala.inline
  def withComponent(f: js.Any => js.Any): this.type = {
    args.update(0, f(args(0)))
    this
  }
  
  @scala.inline
  def withKey(key: Key): this.type = set("key", key.asInstanceOf[js.Any])
  
  @scala.inline
  def withRef(ref: Simple[R]): this.type = set("ref", ref.rawSetFn)
  @scala.inline
  def withRef(ref: R => Unit): this.type = set("ref", ref)
}
object StBuildingComponent {
  
  @JSImport("react", JSImport.Namespace, "React")
  @js.native
  object ReactRaw extends StObject {
    
    val createElement: js.Dynamic = js.native
  }
  
  class Default[R <: js.Object] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[R]
  
  @scala.inline
  implicit def make[R <: js.Object](comp: StBuildingComponent[R]): VdomElement = {
    if (!scalajs.runtime.linkingInfo.productionMode) {
    if (comp.args(0) == null) throw new IllegalStateException("This component has already been built into a ReactElement, and cannot be reused")
  }
    val ret = (ReactRaw.createElement.applyDynamic("apply")(ReactRaw, comp.args)).asInstanceOf[Element]
    if (!scalajs.runtime.linkingInfo.productionMode) {
    comp.args.update(0, null)
  }
    VdomElement(ret)
  }
}
