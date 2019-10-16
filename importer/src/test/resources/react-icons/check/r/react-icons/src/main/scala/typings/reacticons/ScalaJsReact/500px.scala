package typings.reactIcons.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactIconBase.reactIconBaseMod.IconBaseProps
import typings.reactIcons.fa500pxMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object `500px` {
  def apply(size: String | Double = null): UnmountedWithRoot[IconBaseProps, default, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
      if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactIconBase.reactIconBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.None, 
  typings.reactIcons.fa500pxMod.default](js.constructorOf[typings.reactIcons.fa500pxMod.default])
    f(__obj.asInstanceOf[typings.reactIconBase.reactIconBaseMod.IconBaseProps])
  }
}

