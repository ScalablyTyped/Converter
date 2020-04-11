package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import org.scalajs.dom.raw.SVGElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SVGFactory extends DOMFactory[SVGAttributes[SVGElement], SVGElement] {
  def apply(): ReactSVGElement = js.native
  def apply(children: ReactNode*): ReactSVGElement = js.native
  def apply(
    props: ClassAttributes[typingsJapgolly.std.SVGElement] with SVGAttributes[typingsJapgolly.std.SVGElement],
    children: Node*
  ): ReactSVGElement = js.native
}

