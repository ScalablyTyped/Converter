package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsRevealRevealContentMod.RevealContentProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object RevealContent {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    hidden: js.UndefOr[Boolean] = js.undefined,
    visible: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedSimple[
    RevealContentProps, 
    MountedWithRawType[RevealContentProps, js.Object, RawMounted[RevealContentProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden)
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsRevealRevealContentMod.RevealContentProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsRevealRevealContentMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsRevealRevealContentMod.RevealContentProps])(children: _*)
  }
}

