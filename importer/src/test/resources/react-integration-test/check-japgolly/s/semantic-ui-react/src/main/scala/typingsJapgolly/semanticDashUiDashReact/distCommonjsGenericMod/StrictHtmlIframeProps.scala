package typingsJapgolly.semanticDashUiDashReact.distCommonjsGenericMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlIframeProps extends js.Object {
  var src: js.UndefOr[String] = js.native
}

object StrictHtmlIframeProps {
  @scala.inline
  def apply(src: String = null): StrictHtmlIframeProps = {
    val __obj = js.Dynamic.literal()
    if (src != null) __obj.updateDynamic("src")(src.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlIframeProps]
  }
}

