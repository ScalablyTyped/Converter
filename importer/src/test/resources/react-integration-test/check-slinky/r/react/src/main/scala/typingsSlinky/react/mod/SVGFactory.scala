package typingsSlinky.react.mod

import slinky.core.TagMod
import typingsSlinky.std.SVGElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SVGFactory extends DOMFactory[SVGAttributes[SVGElement], SVGElement] {
  def apply(): ReactSVGElement = js.native
  def apply(children: ReactNode*): ReactSVGElement = js.native
  def apply(props: ClassAttributes[SVGElement] with SVGAttributes[SVGElement], children: TagMod[Any]*): ReactSVGElement = js.native
}

