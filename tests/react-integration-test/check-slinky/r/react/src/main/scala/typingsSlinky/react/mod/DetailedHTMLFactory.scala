package typingsSlinky.react.mod

import org.scalajs.dom.raw.HTMLElement
import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DetailedHTMLFactory[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */] extends DOMFactory[P, T] {
  def apply(): DetailedReactHTMLElement[P, T] = js.native
  def apply(children: TagMod[Any]*): DetailedReactHTMLElement[P, T] = js.native
  def apply(props: ClassAttributes[T] with P, children: TagMod[Any]*): DetailedReactHTMLElement[P, T] = js.native
}

