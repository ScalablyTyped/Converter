package typings.atStardustUiReactComponentRef.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import typings.atStardustUiReactComponentRef.esTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref {
  def apply(
    key: js.UndefOr[Key] = js.undefined,
    innerRef: japgolly.scalajs.react.raw.React.Ref = null
  )(
    children: ChildArg*
  ): UnmountedSimple[RefProps, MountedWithRawType[RefProps, js.Object, RawMounted[RefProps, js.Object]]] = {
    val __obj = js.Dynamic.literal()
  
    
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.atStardustUiReactComponentRef.esTypesMod.RefProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.atStardustUiReactComponentRef.esRefMod.default)
    f(__obj.asInstanceOf[typings.atStardustUiReactComponentRef.esTypesMod.RefProps])(children: _*)
  }
}

