package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsRailRailMod.RailProps
import typings.semanticUiReact.genericMod.SemanticFLOATS
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.semanticUiReactStrings.big
import typings.semanticUiReact.semanticUiReactStrings.huge
import typings.semanticUiReact.semanticUiReactStrings.large
import typings.semanticUiReact.semanticUiReactStrings.massive
import typings.semanticUiReact.semanticUiReactStrings.mini
import typings.semanticUiReact.semanticUiReactStrings.small
import typings.semanticUiReact.semanticUiReactStrings.tiny
import typings.semanticUiReact.semanticUiReactStrings.very
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Rail {
  def apply(
    position: SemanticFLOATS,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    attached: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    close: Boolean | very = null,
    content: SemanticShorthandContent = null,
    dividing: js.UndefOr[Boolean] = js.undefined,
    internal: js.UndefOr[Boolean] = js.undefined,
    size: mini | tiny | small | large | big | huge | massive = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    RailProps, 
    MountedWithRawType[RailProps, js.Object, RawMounted[RailProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal(position = position)
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(attached)) __obj.updateDynamic("attached")(attached)
    if (className != null) __obj.updateDynamic("className")(className)
    if (close != null) __obj.updateDynamic("close")(close.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(dividing)) __obj.updateDynamic("dividing")(dividing)
    if (!js.isUndefined(internal)) __obj.updateDynamic("internal")(internal)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsRailRailMod.RailProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsRailMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsRailRailMod.RailProps])(children: _*)
  }
}

