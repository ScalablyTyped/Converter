package typingsJapgolly.atStardustDashUiReactDashComponentDashRef.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref {
  def apply(
    innerRef: japgolly.scalajs.react.raw.React.Ref,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[RefProps, MountedWithRawType[RefProps, js.Object, RawMounted[RefProps, js.Object]]] = {
    val __obj = js.Dynamic.literal(innerRef = innerRef.asInstanceOf[js.Any])
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsComponent[
  typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsRefMod.default)
    f(__obj.asInstanceOf[typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps])(children: _*)
  }
}

