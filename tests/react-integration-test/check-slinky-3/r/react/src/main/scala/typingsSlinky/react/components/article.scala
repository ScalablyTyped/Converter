package typingsSlinky.react.components

import _root_.typingsSlinky.react.mod.DetailedHTMLProps
import _root_.typingsSlinky.react.mod.HTMLAttributes
import org.scalajs.dom.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object article {
  
  type Props = DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  
  val component: String = "article"
  
  implicit def make(companion: article.type): SharedBuilder_DetailedHTMLProps_1670340210[HTMLElement] = new SharedBuilder_DetailedHTMLProps_1670340210[HTMLElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): SharedBuilder_DetailedHTMLProps_1670340210[HTMLElement] = new SharedBuilder_DetailedHTMLProps_1670340210[HTMLElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
