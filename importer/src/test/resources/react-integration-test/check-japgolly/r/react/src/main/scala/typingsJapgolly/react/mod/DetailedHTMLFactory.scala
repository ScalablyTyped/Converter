package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DetailedHTMLFactory[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */] extends DOMFactory[P, T] {
  def apply(): DetailedReactHTMLElement[P, T] = js.native
  def apply(children: ReactNode*): DetailedReactHTMLElement[P, T] = js.native
  def apply(props: ClassAttributes[T] with P, children: Node*): DetailedReactHTMLElement[P, T] = js.native
}

