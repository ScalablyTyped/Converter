package typings.react.mod

import typings.react.reactStrings.animate
import typings.react.reactStrings.circle
import typings.react.reactStrings.clipPath
import typings.std.SVGElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// ReactSVG for ReactSVGElement
@js.native
trait ReactSVGElement extends DOMElement[SVGAttributes[SVGElement], SVGElement] {
  @JSName("type")
  var type_ReactSVGElement: animate | circle | clipPath = js.native
}

object ReactSVGElement {
  @scala.inline
  def apply(props: js.Any, ref: Ref[SVGElement], `type`: animate | circle | clipPath): ReactSVGElement = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], ref = ref.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactSVGElement]
  }
  @scala.inline
  implicit class ReactSVGElementOps[Self <: ReactSVGElement] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setType(value: animate | circle | clipPath): Self = this.set("type", value.asInstanceOf[js.Any])
  }
  
}

