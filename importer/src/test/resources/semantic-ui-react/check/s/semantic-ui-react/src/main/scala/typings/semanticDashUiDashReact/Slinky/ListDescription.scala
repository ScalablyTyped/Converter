package typings.semanticDashUiDashReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.semanticDashUiDashReact.srcElementsListListDescriptionMod.ListDescriptionProps
import typings.semanticDashUiDashReact.srcElementsListListDescriptionMod.default
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className */
object ListDescription
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  override val component: String | js.Object = typings.semanticDashUiDashReact.srcElementsListListDescriptionMod.default.asInstanceOf[String | js.Object]
  type dummy = default.type
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ListDescriptionProps
}
