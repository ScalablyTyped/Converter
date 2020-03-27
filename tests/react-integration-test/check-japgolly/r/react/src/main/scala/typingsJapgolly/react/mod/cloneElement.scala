package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.DomElement
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
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
  def apply[P](element: FunctionComponentElement[P], props: Partial[P] with Attributes, children: Node*): FunctionComponentElement[P] = js.native
  def apply[P](element: ReactElement): Element = js.native
  def apply[P](element: ReactElement, props: Partial[P] with Attributes, children: Node*): Element = js.native
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](element: CElement[P, T]): CElement[P, T] = js.native
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](element: CElement[P, T], props: Partial[P] with ClassAttributes[T], children: Node*): CElement[P, T] = js.native
  // DOM Element (has to be the last, because type checking stops at first overload that fits)
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](element: DOMElement[P, T]): DomElement = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](element: DOMElement[P, T], props: DOMAttributes[T] with P, children: Node*): DomElement = js.native
  // DOM Elements
  // ReactHTMLElement
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: DetailedReactHTMLElement[P, T]): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: DetailedReactHTMLElement[P, T], props: P, children: Node*): DetailedReactHTMLElement[P, T] = js.native
  // SVGElement
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: P, children: Node*): ReactSVGElement = js.native
}

