package typingsJapgolly.react.components

import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.anon.Children
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_Children827722549 () {
  val componentImport: js.Any
  def apply(key: Key = null, _overrides: StringDictionary[js.Any] = null)(children: ChildArg*): UnmountedSimple[Children, MountedWithRawType[Children, js.Object, RawMounted[Children, js.Object]]] = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = JsComponent[Children, Varargs, js.Object](this.componentImport)
    f(__obj.asInstanceOf[Children])(children :_*)
  }
}

