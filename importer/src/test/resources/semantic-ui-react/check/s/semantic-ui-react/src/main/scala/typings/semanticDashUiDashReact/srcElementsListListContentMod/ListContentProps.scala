package typings.semanticDashUiDashReact.srcElementsListListContentMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.reactMod.ReactNode
import typings.semanticDashUiDashReact.srcElementsListListDescriptionMod.ListDescriptionProps
import typings.semanticDashUiDashReact.srcElementsListListHeaderMod.ListHeaderProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcGenericMod.SemanticVERTICALALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ListContentProps
  extends StrictListContentProps
     with /* key */ StringDictionary[js.Any]

object ListContentProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    description: SemanticShorthandItem[ListDescriptionProps] = null,
    floated: SemanticFLOATS = null,
    header: SemanticShorthandItem[ListHeaderProps] = null,
    verticalAlign: SemanticVERTICALALIGNMENTS = null
  ): ListContentProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description.asInstanceOf[js.Any])
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (header != null) __obj.updateDynamic("header")(header.asInstanceOf[js.Any])
    if (verticalAlign != null) __obj.updateDynamic("verticalAlign")(verticalAlign)
    __obj.asInstanceOf[ListContentProps]
  }
}

