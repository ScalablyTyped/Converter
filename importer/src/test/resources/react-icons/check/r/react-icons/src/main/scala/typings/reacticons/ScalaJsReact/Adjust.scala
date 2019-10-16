package typings.reactIcons.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactIconBase.reactIconBaseMod.IconBaseProps
import typings.reactIcons.faAdjustMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Adjust {
  def apply(size: String | Double = null): UnmountedWithRoot[IconBaseProps, default, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
      if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactIconBase.reactIconBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.None, 
  typings.reactIcons.faAdjustMod.default](js.constructorOf[typings.reactIcons.faAdjustMod.default])
    f(__obj.asInstanceOf[typings.reactIconBase.reactIconBaseMod.IconBaseProps])
  }
}

