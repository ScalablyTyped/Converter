package typingsJapgolly.semanticDashUiDashReact.srcGenericMod

import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait HtmlLabelProps
  extends StrictHtmlLabelProps
     with /* key */ StringDictionary[js.Any]

object HtmlLabelProps {
  @scala.inline
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, children: VdomNode = null): HtmlLabelProps = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    __obj.asInstanceOf[HtmlLabelProps]
  }
}

