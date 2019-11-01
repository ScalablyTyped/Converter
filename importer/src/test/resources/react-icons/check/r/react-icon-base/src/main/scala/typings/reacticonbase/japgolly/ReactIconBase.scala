package typings.reactIconBase.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactIconBase.reactIconBaseMod.IconBaseProps
import typings.reactIconBase.reactIconBaseMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactIconBase {
  def apply(key: js.UndefOr[Key] = js.undefined, size: String | Double = null)(children: ChildArg*): UnmountedWithRoot[IconBaseProps, default, Unit, IconBaseProps] = {
    val __obj = js.Dynamic.literal()
  
    
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactIconBase.reactIconBaseMod.IconBaseProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactIconBase.reactIconBaseMod.default](js.constructorOf[typings.reactIconBase.reactIconBaseMod.default])
    f(__obj.asInstanceOf[typings.reactIconBase.reactIconBaseMod.IconBaseProps])(children: _*)
  }
}

