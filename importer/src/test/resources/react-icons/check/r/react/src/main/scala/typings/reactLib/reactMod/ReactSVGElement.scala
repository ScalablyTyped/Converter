package typings
package reactLib.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// ReactSVG for ReactSVGElement
trait ReactSVGElement
  extends DOMElement[SVGAttributes[reactLib.SVGElement], reactLib.SVGElement] {
  @JSName("type")
  var type_ReactSVGElement: reactLib.reactLibStrings.animate | reactLib.reactLibStrings.circle | reactLib.reactLibStrings.clipPath
}

object ReactSVGElement {
  @scala.inline
  def apply(
    props: js.Any,
    ref: Ref[reactLib.SVGElement],
    `type`: reactLib.reactLibStrings.animate | reactLib.reactLibStrings.circle | reactLib.reactLibStrings.clipPath,
    key: Key = null
  ): ReactSVGElement = {
    val __obj = js.Dynamic.literal(props = props, ref = ref.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactSVGElement]
  }
}

