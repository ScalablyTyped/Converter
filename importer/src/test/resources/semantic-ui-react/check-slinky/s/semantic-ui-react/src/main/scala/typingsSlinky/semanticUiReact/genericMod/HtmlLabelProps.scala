package typingsSlinky.semanticUiReact.genericMod

import org.scalablytyped.runtime.StringDictionary
import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait HtmlLabelProps
  extends StrictHtmlLabelProps
     with /* key */ StringDictionary[js.Any]

object HtmlLabelProps {
  @scala.inline
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, children: TagMod[Any] = null): HtmlLabelProps = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[HtmlLabelProps]
  }
}

