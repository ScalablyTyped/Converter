package typings.react.reactMod._Global_.JSX

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.HTMLElement
import typings.react.SVGElement
import typings.react.reactMod.DetailedHTMLProps
import typings.react.reactMod.HTMLAttributes
import typings.react.reactMod.SVGProps
import scala.scalajs.js
import scala.scalajs.js.`|`

trait IntrinsicElements extends js.Object {
  // HTML
  var abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  var animate: SVGProps[SVGElement]
}

object IntrinsicElements {
  @inline
  def apply(abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement], animate: SVGProps[SVGElement]): IntrinsicElements = {
    val __obj = js.Dynamic.literal(abbr = abbr, animate = animate)
  
    __obj.asInstanceOf[IntrinsicElements]
  }
}

