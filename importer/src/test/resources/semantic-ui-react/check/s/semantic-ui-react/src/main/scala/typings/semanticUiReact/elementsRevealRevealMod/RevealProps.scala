package typings.semanticUiReact.elementsRevealRevealMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.reactMod.ReactNode
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.semanticUiReactStrings.`move down`
import typings.semanticUiReact.semanticUiReactStrings.`move right`
import typings.semanticUiReact.semanticUiReactStrings.`move up`
import typings.semanticUiReact.semanticUiReactStrings.`rotate left`
import typings.semanticUiReact.semanticUiReactStrings.`small fade`
import typings.semanticUiReact.semanticUiReactStrings.fade
import typings.semanticUiReact.semanticUiReactStrings.move
import typings.semanticUiReact.semanticUiReactStrings.rotate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait RevealProps
  extends StrictRevealProps
     with /* key */ StringDictionary[js.Any]

object RevealProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    animated: fade | (`small fade`) | move | (`move right`) | (`move up`) | (`move down`) | rotate | (`rotate left`) = null,
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    instant: js.UndefOr[Boolean] = js.undefined
  ): RevealProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (animated != null) __obj.updateDynamic("animated")(animated.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(instant)) __obj.updateDynamic("instant")(instant)
    __obj.asInstanceOf[RevealProps]
  }
}

