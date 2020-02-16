package typingsSlinky.react.mod

import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import slinky.core.ReactComponentClass
import slinky.core.TagMod
import typingsSlinky.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "cloneElement")
@js.native
object cloneElement extends js.Object {
  // Custom components
  def apply[P](element: FunctionComponentElement[P]): FunctionComponentElement[P] = js.native
  def apply[P](element: FunctionComponentElement[P], props: Partial[P] with Attributes, children: TagMod[Any]*): FunctionComponentElement[P] = js.native
  def apply[P](element: ReactElement): slinky.core.facade.ReactElement = js.native
  def apply[P](element: ReactElement, props: Partial[P] with Attributes, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  def apply[P, T /* <: ReactComponentClass[P] */](element: CElement[P, T]): CElement[P, T] = js.native
  def apply[P, T /* <: ReactComponentClass[P] */](element: CElement[P, T], props: Partial[P] with ClassAttributes[T], children: TagMod[Any]*): CElement[P, T] = js.native
  // DOM Element (has to be the last, because type checking stops at first overload that fits)
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](element: DOMElement[P, T]): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](element: DOMElement[P, T], props: DOMAttributes[T] with P, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  // ReactHTMLElement, less specific
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: ReactHTMLElement[T]): ReactHTMLElement[T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: ReactHTMLElement[T], props: P, children: TagMod[Any]*): ReactHTMLElement[T] = js.native
  // SVGElement
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: P, children: TagMod[Any]*): ReactSVGElement = js.native
}

