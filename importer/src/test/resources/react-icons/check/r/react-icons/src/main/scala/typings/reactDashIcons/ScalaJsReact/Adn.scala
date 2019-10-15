package typings.reactDashIcons.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps
import typings.reactDashIcons.faAdnMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Adn {
  def apply(size: String | Double = null): UnmountedWithRoot[IconBaseProps, default, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
      if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.None, 
  typings.reactDashIcons.faAdnMod.default](js.constructorOf[typings.reactDashIcons.faAdnMod.default])
    f(__obj.asInstanceOf[typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps])
  }
}

