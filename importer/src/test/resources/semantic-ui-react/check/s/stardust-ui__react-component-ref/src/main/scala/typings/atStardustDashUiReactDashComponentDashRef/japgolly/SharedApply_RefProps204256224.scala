package typings.atStardustDashUiReactDashComponentDashRef.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Ref
import typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_RefProps204256224[ComponentRef] () {
  def __component: js.Any
  def apply(innerRef: Ref = null, key: js.UndefOr[Key] = js.undefined)(children: ChildArg*): UnmountedWithRoot[RefProps, ComponentRef, Unit, RefProps] = {
    val __obj = js.Dynamic.literal()
  
      if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps, 
  japgolly.scalajs.react.Children.Varargs, 
  ComponentRef](__component)
    f(__obj.asInstanceOf[typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps])(children: _*)
  }
}

