package typingsSlinky.react.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.react.anon.Html
import _root_.typingsSlinky.react.mod.DetailedHTMLProps
import _root_.typingsSlinky.react.mod.HTMLAttributes
import org.scalajs.dom.HTMLElement
import slinky.web.html.abbr.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object abbr {
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, HTMLElement] {
    
    inline def dangerouslySetInnerHTML(value: Html): this.type = set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    inline def defaultChecked(value: Boolean): this.type = set("defaultChecked", value.asInstanceOf[js.Any])
  }
  
  type Props = DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  
  val component: String = "abbr"
  
  implicit def make(companion: abbr.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
