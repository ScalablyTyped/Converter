package typings.japgolly.reactDashIconDashBase

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDashIconDashBase {
  def apply(
    size: String | Double = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[IconBaseProps, default, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
      if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactDashIconDashBase.reactDashIconDashBaseMod.default](js.constructorOf[typings.reactDashIconDashBase.reactDashIconDashBaseMod.default])
    f(__obj.asInstanceOf[typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps])(children: _*)
  }
}

