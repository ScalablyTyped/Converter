package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.raw.React.ComponentClassP
import japgolly.scalajs.react.raw.React.DomElement
import japgolly.scalajs.react.raw.React.Element
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "createElement")
@js.native
object createElement extends js.Object {
  def apply[P /* <: js.Object */](`type`: String): Element = js.native
  def apply[P /* <: js.Object */](`type`: String, children: ReactNode*): Element = js.native
  def apply[P /* <: js.Object */](`type`: String, props: Attributes with P, children: ReactNode*): Element = js.native
  def apply[P /* <: js.Object */](`type`: ClassType[P, ClassicComponent[P, ComponentState], ClassicComponentClass[P]]): CElement[P, ClassicComponent[P, js.Object]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ClassicComponent[P, ComponentState], ClassicComponentClass[P]],
    children: ReactNode*
  ): CElement[P, ClassicComponent[P, js.Object]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ClassicComponent[P, ComponentState], ClassicComponentClass[P]],
    props: (ClassAttributes[ClassicComponent[P, ComponentState]]) with P,
    children: ReactNode*
  ): CElement[P, ClassicComponent[P, js.Object]] = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState]): Element = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState], children: ReactNode*): Element = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState], props: Attributes with P, children: ReactNode*): Element = js.native
  // Custom components
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P]): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], children: ReactNode*): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: Attributes with P, children: ReactNode*): FunctionComponentElement[P] = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: String, props: ClassAttributes[T] with P, children: ReactNode*): DomElement = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    children: ReactNode*
  ): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: ClassAttributes[T] with P,
    children: ReactNode*
  ): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: ComponentClassP[P with js.Object] */](`type`: ClassType[P, T, C]): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: ComponentClassP[P with js.Object] */](`type`: ClassType[P, T, C], children: ReactNode*): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: ComponentClassP[P with js.Object] */](`type`: ClassType[P, T, C], props: ClassAttributes[T] with P, children: ReactNode*): CElement[P, T] = js.native
}

