package typings.reactLib.reactMod.Global.JSXNs

import typings.reactLib.HTMLElement
import typings.reactLib.SVGElement
import typings.reactLib.reactMod.DetailedHTMLProps
import typings.reactLib.reactMod.HTMLAttributes
import typings.reactLib.reactMod.SVGProps
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

