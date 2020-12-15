package typingsSlinky.react.mod

import org.scalajs.dom.raw.Document
import org.scalajs.dom.raw.StyleMedia
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

//
// Browser Interfaces
// https://github.com/nikeee/2048-typescript/blob/master/2048/js/touch.d.ts
// ----------------------------------------------------------------------
@js.native
trait AbstractView extends StObject {
  
  var document: Document = js.native
  
  var styleMedia: StyleMedia = js.native
}
object AbstractView {
  
  @scala.inline
  def apply(document: Document, styleMedia: StyleMedia): AbstractView = {
    val __obj = js.Dynamic.literal(document = document.asInstanceOf[js.Any], styleMedia = styleMedia.asInstanceOf[js.Any])
    __obj.asInstanceOf[AbstractView]
  }
  
  @scala.inline
  implicit class AbstractViewMutableBuilder[Self <: AbstractView] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setDocument(value: Document): Self = StObject.set(x, "document", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setStyleMedia(value: StyleMedia): Self = StObject.set(x, "styleMedia", value.asInstanceOf[js.Any])
  }
}
