package typingsSlinky.react.mod

import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DetailedHTMLFactory[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */] extends DOMFactory[P, T] {
  def apply(): DetailedReactHTMLElement[P, T] = js.native
  def apply(children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[P, T] = js.native
  def apply(props: ClassAttributes[T] with P, children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[P, T] = js.native
}

