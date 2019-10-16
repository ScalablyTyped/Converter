package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.semanticUiReact.elementsRevealRevealMod.RevealProps
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

/* The following DOM/SVG props were specified: children, className, disabled */
object Reveal
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  override val component: String | js.Object = typings.semanticUiReact.elementsRevealMod.default.asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    animated: fade | (`small fade`) | move | (`move right`) | (`move up`) | (`move down`) | rotate | (`rotate left`) = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    instant: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (animated != null) __obj.updateDynamic("animated")(animated.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(instant)) __obj.updateDynamic("instant")(instant)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = RevealProps
}

