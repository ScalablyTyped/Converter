package typings
package reactLib.reactMod.Global.JSXNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait IntrinsicElements extends js.Object {
  // HTML
  var abbr: reactLib.reactMod.ReactNs.DetailedHTMLProps[
    reactLib.reactMod.ReactNs.HTMLAttributes[reactLib.HTMLElement], 
    reactLib.HTMLElement
  ]
  var animate: reactLib.reactMod.ReactNs.SVGProps[reactLib.SVGElement]
}

object IntrinsicElements {
  @scala.inline
  def apply(
    abbr: reactLib.reactMod.ReactNs.DetailedHTMLProps[
      reactLib.reactMod.ReactNs.HTMLAttributes[reactLib.HTMLElement], 
      reactLib.HTMLElement
    ],
    animate: reactLib.reactMod.ReactNs.SVGProps[reactLib.SVGElement]
  ): IntrinsicElements = {
    val __obj = js.Dynamic.literal(abbr = abbr, animate = animate)
  
    __obj.asInstanceOf[IntrinsicElements]
  }
}

