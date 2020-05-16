package typingsSlinky.react.mod._Global_.JSX

import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import typingsSlinky.react.mod.DetailedHTMLProps
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.react.mod.SVGProps
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
  @scala.inline
  implicit class IntrinsicElementsOps[Self <: IntrinsicElements] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAbbr(abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("abbr")(abbr.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAnimate(animate: SVGProps[SVGElement]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("animate")(animate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

