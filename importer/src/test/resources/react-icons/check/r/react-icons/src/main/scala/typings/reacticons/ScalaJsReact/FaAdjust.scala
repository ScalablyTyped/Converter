package typings.reactIcons.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactIconBase.reactIconBaseMod.IconBaseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object FaAdjust {
  def apply(size: String | Double = null): UnmountedWithRoot[IconBaseProps, typings.reactIcons.faMod.FaAdjust, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
      if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactIconBase.reactIconBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.None, 
  typings.reactIcons.faMod.FaAdjust](js.constructorOf[typings.reactIcons.faMod.FaAdjust])
    f(__obj.asInstanceOf[typings.reactIconBase.reactIconBaseMod.IconBaseProps])
  }
}

