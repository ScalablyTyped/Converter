package typingsJapgolly.react.mod.global.JSX

import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import typingsJapgolly.react.mod.DetailedHTMLProps
import typingsJapgolly.react.mod.HTMLAttributes
import typingsJapgolly.react.mod.SVGProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait IntrinsicElements extends js.Object {
  
  // HTML
  var abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
  
  var animate: SVGProps[SVGElement] = js.native
}
object IntrinsicElements {
  
  @scala.inline
  def apply(abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement], animate: SVGProps[SVGElement]): IntrinsicElements = {
    val __obj = js.Dynamic.literal(abbr = abbr.asInstanceOf[js.Any], animate = animate.asInstanceOf[js.Any])
    __obj.asInstanceOf[IntrinsicElements]
  }
}
