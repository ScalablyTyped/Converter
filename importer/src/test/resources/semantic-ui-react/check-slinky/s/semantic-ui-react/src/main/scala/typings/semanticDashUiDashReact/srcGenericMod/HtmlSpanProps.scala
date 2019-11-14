package typings.semanticDashUiDashReact.srcGenericMod

import org.scalablytyped.runtime.StringDictionary
import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait HtmlSpanProps
  extends StrictHtmlSpanProps
     with /* key */ StringDictionary[js.Any]

object HtmlSpanProps {
  @scala.inline
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, children: TagMod[Any] = null): HtmlSpanProps = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (children != null) __obj.updateDynamic("children")(children)
    __obj.asInstanceOf[HtmlSpanProps]
  }
}

