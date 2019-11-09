package typings.japgolly.atStardustDashUiReactDashComponentDashRef

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref {
  def apply(
    innerRef: japgolly.scalajs.react.raw.React.Ref = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[RefProps, MountedWithRawType[RefProps, js.Object, RawMounted[RefProps, js.Object]]] = {
    val __obj = js.Dynamic.literal()
  
      if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.atStardustDashUiReactDashComponentDashRef.distEsRefMod.default)
    f(__obj.asInstanceOf[typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps])(children: _*)
  }
}

