package typingsJapgolly.react.components

import org.scalajs.dom.HTMLElement
import typingsJapgolly.react.mod.DetailedHTMLProps
import typingsJapgolly.react.mod.HTMLAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object address {
  
  type Props = DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  
  val component: String = "address"
  
  implicit def make(companion: address.type): SharedBuilder_DetailedHTMLProps_19736828[HTMLElement] = new SharedBuilder_DetailedHTMLProps_19736828[HTMLElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): SharedBuilder_DetailedHTMLProps_19736828[HTMLElement] = new SharedBuilder_DetailedHTMLProps_19736828[HTMLElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
