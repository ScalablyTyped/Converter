package typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderParagraphMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.reactMod.ReactNode
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait PlaceholderParagraphProps
  extends StrictPlaceholderParagraphProps
     with /* key */ StringDictionary[js.Any]

object PlaceholderParagraphProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    content: SemanticShorthandContent = null
  ): PlaceholderParagraphProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    __obj.asInstanceOf[PlaceholderParagraphProps]
  }
}

