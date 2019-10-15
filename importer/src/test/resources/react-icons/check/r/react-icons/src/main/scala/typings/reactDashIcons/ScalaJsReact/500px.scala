package typings.reactDashIcons.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps
import typings.reactDashIcons.fa500pxMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object `500px` {
  def apply(size: String | Double = null): UnmountedWithRoot[IconBaseProps, default, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
      if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.None, 
  typings.reactDashIcons.fa500pxMod.default](js.constructorOf[typings.reactDashIcons.fa500pxMod.default])
    f(__obj.asInstanceOf[typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps])
  }
}

