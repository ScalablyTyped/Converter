package typings.semanticDashUiDashReact.srcGenericMod

import japgolly.scalajs.react.raw.React.Node
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait HtmlSpanProps
  extends StrictHtmlSpanProps
     with /* key */ StringDictionary[js.Any]

object HtmlSpanProps {
  @scala.inline
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, children: Node = null): HtmlSpanProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[HtmlSpanProps]
  }
}

