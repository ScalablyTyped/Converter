package typings.react.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import typings.react.Anon_Children
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_Anon_Children298287606 () {
  def __component: js.Any
  def apply(key: js.UndefOr[Key] = js.undefined)(children: ChildArg*): UnmountedSimple[
    Anon_Children, 
    MountedWithRawType[Anon_Children, js.Object, RawMounted[Anon_Children, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsComponent[typings.react.Anon_Children, japgolly.scalajs.react.Children.Varargs, js.Object](__component)
    f(__obj.asInstanceOf[typings.react.Anon_Children])(children: _*)
  }
}

