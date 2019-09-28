package typings.react.reactMod

import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.SVGElement
import typings.react.reactStrings.animate
import typings.react.reactStrings.circle
import typings.react.reactStrings.clipPath
import scala.scalajs.js
import scala.scalajs.js.`|`

// ReactSVG for ReactSVGElement
trait ReactSVGElement extends DOMElement[SVGAttributes[SVGElement], SVGElement] {
  @JSName("type")
  var type_ReactSVGElement: animate | circle | clipPath
}

object ReactSVGElement {
  @inline
  def apply(props: js.Any, ref: Ref[SVGElement], `type`: animate | circle | clipPath, key: Key = null): ReactSVGElement = {
    val __obj = js.Dynamic.literal(props = props, ref = ref.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactSVGElement]
  }
}

