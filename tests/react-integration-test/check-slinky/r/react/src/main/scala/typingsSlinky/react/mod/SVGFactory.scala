package typingsSlinky.react.mod

import org.scalajs.dom.raw.SVGElement
import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SVGFactory extends DOMFactory[SVGAttributes[SVGElement], SVGElement] {
  def apply(): ReactSVGElement = js.native
  def apply(children: ReactNode*): ReactSVGElement = js.native
  def apply(
    props: ClassAttributes[typingsSlinky.std.SVGElement] with SVGAttributes[typingsSlinky.std.SVGElement],
    children: TagMod[Any]*
  ): ReactSVGElement = js.native
}

