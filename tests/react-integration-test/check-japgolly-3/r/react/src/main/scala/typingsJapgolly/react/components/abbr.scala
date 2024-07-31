package typingsJapgolly.react.components

import _root_.typingsJapgolly.react.mod.DetailedHTMLProps
import _root_.typingsJapgolly.react.mod.HTMLAttributes
import org.scalajs.dom.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object abbr {
  
  type Props = DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  
  val component: String = "abbr"
  
  implicit def make(companion: abbr.type): SharedBuilder_DetailedHTMLProps1253650682[HTMLElement] = new SharedBuilder_DetailedHTMLProps1253650682[HTMLElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): SharedBuilder_DetailedHTMLProps1253650682[HTMLElement] = new SharedBuilder_DetailedHTMLProps1253650682[HTMLElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
