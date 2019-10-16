package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.semanticUiReact.elementsPlaceholderPlaceholderLineMod.PlaceholderLineProps
import typings.semanticUiReact.semanticUiReactStrings.`very long`
import typings.semanticUiReact.semanticUiReactStrings.`very short`
import typings.semanticUiReact.semanticUiReactStrings.full
import typings.semanticUiReact.semanticUiReactStrings.long
import typings.semanticUiReact.semanticUiReactStrings.medium
import typings.semanticUiReact.semanticUiReactStrings.short
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className */
object PlaceholderLine
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  override val component: String | js.Object = typings.semanticUiReact.elementsPlaceholderPlaceholderLineMod.default.asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    length: full | (`very long`) | long | medium | short | (`very short`) = null
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (length != null) __obj.updateDynamic("length")(length.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = PlaceholderLineProps
}

