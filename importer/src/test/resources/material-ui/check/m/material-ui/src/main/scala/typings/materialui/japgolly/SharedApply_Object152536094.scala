package typings.materialUi.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_Object152536094[ComponentRef] () {
  def __component: js.Any
  def apply(key: js.UndefOr[Key] = js.undefined)(children: ChildArg*): UnmountedWithRoot[js.Object, ComponentRef, Unit, js.Object] = {
    val __obj = js.Dynamic.literal()
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[js.Object, japgolly.scalajs.react.Children.Varargs, ComponentRef](__component)
    f(__obj.asInstanceOf[js.Object])(children: _*)
  }
}

