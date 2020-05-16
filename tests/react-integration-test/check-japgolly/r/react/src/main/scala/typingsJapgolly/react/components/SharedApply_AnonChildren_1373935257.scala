package typingsJapgolly.react.components

import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.AnonChildren
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_AnonChildren_1373935257 () {
  val componentImport: js.Any
  def apply(key: Key = null, _overrides: StringDictionary[js.Any] = null)(children: ChildArg*): UnmountedSimple[
    AnonChildren, 
    MountedWithRawType[AnonChildren, js.Object, RawMounted[AnonChildren, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = JsComponent[AnonChildren, Varargs, js.Object](this.componentImport)
    f(__obj.asInstanceOf[AnonChildren])(children :_*)
  }
}

