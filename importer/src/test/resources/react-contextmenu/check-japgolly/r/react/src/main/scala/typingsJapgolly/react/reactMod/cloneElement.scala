package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.raw.React.DomElement
import japgolly.scalajs.react.raw.React.Element
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import typingsJapgolly.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "cloneElement")
@js.native
object cloneElement extends js.Object {
  // Custom components
  def apply[P](element: FunctionComponentElement[P]): FunctionComponentElement[P] = js.native
  def apply[P](element: FunctionComponentElement[P], props: Partial[P] with Attributes, children: ReactNode*): FunctionComponentElement[P] = js.native
  def apply[P](element: ReactElement): Element = js.native
  def apply[P](element: ReactElement, props: Partial[P] with Attributes, children: ReactNode*): Element = js.native
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](element: CElement[P, T]): CElement[P, T] = js.native
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](element: CElement[P, T], props: Partial[P] with ClassAttributes[T], children: ReactNode*): CElement[P, T] = js.native
  // DOM Element (has to be the last, because type checking stops at first overload that fits)
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](element: DOMElement[P, T]): DomElement = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](element: DOMElement[P, T], props: DOMAttributes[T] with P, children: ReactNode*): DomElement = js.native
  // ReactHTMLElement, less specific
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: ReactHTMLElement[T]): ReactHTMLElement[T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: ReactHTMLElement[T], props: P, children: ReactNode*): ReactHTMLElement[T] = js.native
  // SVGElement
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: P, children: ReactNode*): ReactSVGElement = js.native
}

