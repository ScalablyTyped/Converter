package typings.reactDashIcons.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Fa500px {
  def apply(size: String | Double = null)(children: ChildArg*): UnmountedWithRoot[IconBaseProps, typings.reactDashIcons.faMod.Fa500px, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
      if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactDashIcons.faMod.Fa500px](js.constructorOf[typings.reactDashIcons.faMod.Fa500px])
    f(__obj.asInstanceOf[typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps])(children: _*)
  }
}

