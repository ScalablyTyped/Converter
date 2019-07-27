package typings
package reactLib.reactMod.Global.JSXNs

import reactLib.HTMLElement
import reactLib.SVGElement
import reactLib.reactMod.DetailedHTMLProps
import reactLib.reactMod.HTMLAttributes
import reactLib.reactMod.SVGProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait IntrinsicElements extends js.Object {
  // HTML
  var abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  var animate: SVGProps[SVGElement]
}

object IntrinsicElements {
  @scala.inline
  def apply(abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement], animate: SVGProps[SVGElement]): IntrinsicElements = {
    val __obj = js.Dynamic.literal(abbr = abbr, animate = animate)
  
    __obj.asInstanceOf[IntrinsicElements]
  }
}

