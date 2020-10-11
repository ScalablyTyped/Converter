package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.ComponentClassP
import japgolly.scalajs.react.raw.React.DomElement
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("react", "createElement")
@js.native
object createElement extends js.Object {
  def apply[P /* <: js.Object */](`type`: String, props: Attributes with P, children: Node*): Element = js.native
  def apply[P /* <: js.Object */](`type`: String, props: js.UndefOr[scala.Nothing], children: Node*): Element = js.native
  def apply[P /* <: js.Object */](`type`: String, props: Null, children: Node*): Element = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ClassicComponent[P, js.Object], ClassicComponentClass[P]],
    props: (ClassAttributes[ClassicComponent[P, js.Object]]) with P,
    children: Node*
  ): CElement[P, ClassicComponent[P, js.Object]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ClassicComponent[P, js.Object], ClassicComponentClass[P]],
    props: js.UndefOr[scala.Nothing],
    children: Node*
  ): CElement[P, ClassicComponent[P, js.Object]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ClassicComponent[P, js.Object], ClassicComponentClass[P]],
    props: Null,
    children: Node*
  ): CElement[P, ClassicComponent[P, js.Object]] = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClassP[P with js.Object], props: Attributes with P, children: Node*): Element = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClassP[P with js.Object], props: js.UndefOr[scala.Nothing], children: Node*): Element = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClassP[P with js.Object], props: Null, children: Node*): Element = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: Attributes with P, children: Node*): Element = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: js.UndefOr[scala.Nothing], children: Node*): Element = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: Null, children: Node*): Element = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: String, props: ClassAttributes[T] with P, children: Node*): DomElement = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: ClassAttributes[T] with P,
    children: Node*
  ): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: js.UndefOr[scala.Nothing],
    children: Node*
  ): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: Null,
    children: Node*
  ): DetailedReactHTMLElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: ComponentClassP[P with js.Object] */](`type`: ClassType[P, T, C], props: ClassAttributes[T] with P, children: Node*): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: ComponentClassP[P with js.Object] */](`type`: ClassType[P, T, C], props: js.UndefOr[scala.Nothing], children: Node*): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: ComponentClassP[P with js.Object] */](`type`: ClassType[P, T, C], props: Null, children: Node*): CElement[P, T] = js.native
}

