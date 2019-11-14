package typings.react.reactMod._Global_.JSX

import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import typings.react.reactMod.DetailedHTMLProps
import typings.react.reactMod.HTMLAttributes
import typings.react.reactMod.SVGProps
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
    val __obj = js.Dynamic.literal(abbr = abbr.asInstanceOf[js.Any], animate = animate.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[IntrinsicElements]
  }
}

