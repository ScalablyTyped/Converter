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
  def apply[P](element: FunctionComponentElement[P], props: Partial[P] with Attributes, children: Node*): FunctionComponentElement[P] = js.native
  def apply[P](element: FunctionComponentElement[P], props: js.UndefOr[scala.Nothing], children: Node*): FunctionComponentElement[P] = js.native
  def apply[P](element: Element, props: Partial[P] with Attributes, children: Node*): Element = js.native
  def apply[P](element: Element, props: js.UndefOr[scala.Nothing], children: Node*): Element = js.native
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](element: CElement[P, T], props: Partial[P] with ClassAttributes[T], children: Node*): CElement[P, T] = js.native
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](element: CElement[P, T], props: js.UndefOr[scala.Nothing], children: Node*): CElement[P, T] = js.native
  // DOM Element (has to be the last, because type checking stops at first overload that fits)
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](element: DomElement, props: DOMAttributes[T] with P, children: Node*): DomElement = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](element: DomElement, props: js.UndefOr[scala.Nothing], children: Node*): DomElement = js.native
  // DOM Elements
  // ReactHTMLElement
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: DetailedReactHTMLElement[P, T], props: P, children: Node*): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: DetailedReactHTMLElement[P, T], props: js.UndefOr[scala.Nothing], children: Node*): DetailedReactHTMLElement[P, T] = js.native
  // SVGElement
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: P, children: Node*): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: js.UndefOr[scala.Nothing], children: Node*): ReactSVGElement = js.native
}

