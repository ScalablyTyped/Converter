package typingsJapgolly.componentstest.components

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.componentstest.componentstestMod.Props
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Component {
  def A(
    aMember: Double,
    aCallback: CallbackTo[Double],
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[Props, typingsJapgolly.componentstest.componentstestMod.Component, Unit, Props] = {
    val __obj = js.Dynamic.literal(aMember = aMember.asInstanceOf[js.Any])
  
      __obj.updateDynamic("aCallback")(aCallback.toJsFn)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.componentstest.componentstestMod.Props, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.componentstest.componentstestMod.Component](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.componentstest.componentstestMod.Props])(children: _*)
  }
  def B(
    bMember: String,
    bCallback: js.UndefOr[CallbackTo[String]] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[Props, typingsJapgolly.componentstest.componentstestMod.Component, Unit, Props] = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
  
      bCallback.foreach(p => __obj.updateDynamic("bCallback")(p.toJsFn))
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.componentstest.componentstestMod.Props, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.componentstest.componentstestMod.Component](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.componentstest.componentstestMod.Props])(children: _*)
  }
  @JSImport("componentstest", "Component")
  @js.native
  object componentImport extends js.Object
  
}

