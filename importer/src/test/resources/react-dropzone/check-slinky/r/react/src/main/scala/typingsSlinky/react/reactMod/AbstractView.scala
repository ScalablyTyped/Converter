package typingsSlinky.react.reactMod

import org.scalajs.dom.raw.Document
import org.scalajs.dom.raw.StyleMedia
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Browser Interfaces
// https://github.com/nikeee/2048-typescript/blob/master/2048/js/touch.d.ts
// ----------------------------------------------------------------------
trait AbstractView extends js.Object {
  var document: Document
  var styleMedia: StyleMedia
}

object AbstractView {
  @scala.inline
  def apply(document: Document, styleMedia: StyleMedia): AbstractView = {
    val __obj = js.Dynamic.literal(document = document.asInstanceOf[js.Any], styleMedia = styleMedia.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[AbstractView]
  }
}

