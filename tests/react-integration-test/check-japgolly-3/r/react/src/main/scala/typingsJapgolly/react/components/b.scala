package typingsJapgolly.react.components

import org.scalajs.dom.HTMLElement
import typingsJapgolly.react.mod.DetailedHTMLProps
import typingsJapgolly.react.mod.HTMLAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object b {
  
  type Props = DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  
  val component: String = "b"
  
  implicit def make(companion: b.type): SharedBuilder_DetailedHTMLProps_364684144[HTMLElement] = new SharedBuilder_DetailedHTMLProps_364684144[HTMLElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): SharedBuilder_DetailedHTMLProps_364684144[HTMLElement] = new SharedBuilder_DetailedHTMLProps_364684144[HTMLElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
