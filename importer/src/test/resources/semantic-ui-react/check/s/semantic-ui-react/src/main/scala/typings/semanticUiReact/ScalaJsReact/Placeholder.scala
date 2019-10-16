package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsPlaceholderPlaceholderMod.PlaceholderProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Placeholder {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedSimple[
    PlaceholderProps, 
    MountedWithRawType[PlaceholderProps, js.Object, RawMounted[PlaceholderProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsPlaceholderPlaceholderMod.PlaceholderProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsPlaceholderMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsPlaceholderPlaceholderMod.PlaceholderProps])(children: _*)
  }
}

