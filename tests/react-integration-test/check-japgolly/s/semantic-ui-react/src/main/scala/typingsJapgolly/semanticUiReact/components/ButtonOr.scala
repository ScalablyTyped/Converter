package typingsJapgolly.semanticUiReact.components

import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonOr {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    text: Double | String = null,
    key: Key = null,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    ButtonOrProps, 
    MountedWithRawType[ButtonOrProps, js.Object, RawMounted[ButtonOrProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (text != null) __obj.updateDynamic("text")(text.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = JsComponent[ButtonOrProps, Varargs, js.Object](this.componentImport)
    f(__obj.asInstanceOf[ButtonOrProps])(children :_*)
  }
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonOr", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}

