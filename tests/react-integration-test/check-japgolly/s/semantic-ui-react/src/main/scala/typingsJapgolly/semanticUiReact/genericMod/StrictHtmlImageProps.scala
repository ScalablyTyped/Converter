package typingsJapgolly.semanticUiReact.genericMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlImageProps extends js.Object {
  var src: js.UndefOr[String] = js.native
}

object StrictHtmlImageProps {
  @scala.inline
  def apply(src: String = null): StrictHtmlImageProps = {
    val __obj = js.Dynamic.literal()
    if (src != null) __obj.updateDynamic("src")(src.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlImageProps]
  }
}

