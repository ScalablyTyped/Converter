package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsFlagFlagMod.FlagNameValues
import typings.semanticUiReact.elementsFlagFlagMod.FlagProps
import typings.semanticUiReact.elementsFlagMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Flag {
  def apply(
    name: FlagNameValues,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[FlagProps, default, Unit, FlagProps] = {
    val __obj = js.Dynamic.literal(name = name)
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.elementsFlagFlagMod.FlagProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.elementsFlagMod.default](js.constructorOf[typings.semanticUiReact.elementsFlagMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsFlagFlagMod.FlagProps])(children: _*)
  }
}

