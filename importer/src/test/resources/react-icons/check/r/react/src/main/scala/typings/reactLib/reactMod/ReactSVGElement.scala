package typings.reactLib.reactMod

import typings.reactLib.SVGElement
import typings.reactLib.reactLibStrings.animate
import typings.reactLib.reactLibStrings.circle
import typings.reactLib.reactLibStrings.clipPath
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// ReactSVG for ReactSVGElement
trait ReactSVGElement extends DOMElement[SVGAttributes[SVGElement], SVGElement] {
  @JSName("type")
  var type_ReactSVGElement: animate | circle | clipPath
}

object ReactSVGElement {
  @scala.inline
  def apply(props: js.Any, ref: Ref[SVGElement], `type`: animate | circle | clipPath, key: Key = null): ReactSVGElement = {
    val __obj = js.Dynamic.literal(props = props, ref = ref.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactSVGElement]
  }
}

