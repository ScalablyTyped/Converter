package typingsJapgolly.react.reactMod._Global_.JSX

import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import typingsJapgolly.react.reactMod.DetailedHTMLProps
import typingsJapgolly.react.reactMod.HTMLAttributes
import typingsJapgolly.react.reactMod.SVGProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

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

