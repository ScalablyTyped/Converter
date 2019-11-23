package typingsJapgolly.atStardustDashUiReactDashComponentDashRef.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_RefProps1889243212[ComponentRef] () {
  def __component: js.Any
  def apply(
    innerRef: japgolly.scalajs.react.raw.React.Ref = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[RefProps, ComponentRef, Unit, RefProps] = {
    val __obj = js.Dynamic.literal()
  
      if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps, 
  japgolly.scalajs.react.Children.Varargs, 
  ComponentRef](__component)
    f(__obj.asInstanceOf[typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps])(children: _*)
  }
}

