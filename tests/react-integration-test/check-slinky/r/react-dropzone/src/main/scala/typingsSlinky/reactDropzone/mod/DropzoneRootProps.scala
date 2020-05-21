package typingsSlinky.reactDropzone.mod

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typingsSlinky.react.mod.HTMLAttributes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DropzoneRootProps
  extends HTMLAttributes[HTMLElement]
     with /* key */ StringDictionary[js.Any] {
  var refKey: js.UndefOr[String] = js.native
}

object DropzoneRootProps {
  @scala.inline
  def apply(): DropzoneRootProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[DropzoneRootProps]
  }
  @scala.inline
  implicit class DropzoneRootPropsOps[Self <: DropzoneRootProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withRefKey(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("refKey")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutRefKey: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("refKey")(js.undefined)
        ret
    }
  }
  
}

