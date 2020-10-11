package typingsSlinky.react.mod

import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGElement
import slinky.core.ReactComponentClass
import typingsSlinky.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("react", "cloneElement")
@js.native
object cloneElement extends js.Object {
  // Custom components
  def apply[P](
    element: FunctionComponentElement[P],
    props: Partial[P] with Attributes,
    children: slinky.core.facade.ReactElement*
  ): FunctionComponentElement[P] = js.native
  def apply[P](
    element: FunctionComponentElement[P],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): FunctionComponentElement[P] = js.native
  def apply[P](
    element: ReactElement,
    props: Partial[P] with Attributes,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = js.native
  def apply[P](
    element: ReactElement,
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = js.native
  def apply[P, T /* <: ReactComponentClass[P] */](
    element: CElement[P, T],
    props: Partial[P] with ClassAttributes[T],
    children: slinky.core.facade.ReactElement*
  ): CElement[P, T] = js.native
  def apply[P, T /* <: ReactComponentClass[P] */](
    element: CElement[P, T],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): CElement[P, T] = js.native
  // DOM Element (has to be the last, because type checking stops at first overload that fits)
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](
    element: DOMElement[P, T],
    props: DOMAttributes[T] with P,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](
    element: DOMElement[P, T],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = js.native
  // ReactHTMLElement, less specific
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: ReactHTMLElement[T], props: P, children: slinky.core.facade.ReactElement*): ReactHTMLElement[T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    element: ReactHTMLElement[T],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): ReactHTMLElement[T] = js.native
  // SVGElement
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: P, children: slinky.core.facade.ReactElement*): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    element: ReactSVGElement,
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): ReactSVGElement = js.native
}

