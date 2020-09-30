package typingsSlinky.react.mod

import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.SVGElement
import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("react", "createElement")
@js.native
object createElement extends js.Object {
  def apply[P /* <: js.Object */](`type`: String, props: Attributes with P, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: String, props: js.UndefOr[scala.Nothing], children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: String, props: Null, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]],
    props: ClassAttributes[ReactComponentClass[P]] with P,
    children: slinky.core.facade.ReactElement*
  ): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]],
    props: Null,
    children: slinky.core.facade.ReactElement*
  ): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ComponentClass[P, js.Object],
    props: Attributes with P,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](
    `type`: ComponentClass[P, js.Object],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, js.Object], props: Null, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = js.native
  // Custom components
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: Attributes with P, children: slinky.core.facade.ReactElement*): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](
    `type`: FunctionComponent[P],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: Null, children: slinky.core.facade.ReactElement*): FunctionComponentElement[P] = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String, props: ClassAttributes[T] with P, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: ClassAttributes[T] with P,
    children: slinky.core.facade.ReactElement*
  ): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: Null,
    children: slinky.core.facade.ReactElement*
  ): ReactSVGElement = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](
    `type`: ClassType[P, T, C],
    props: ClassAttributes[T] with P,
    children: slinky.core.facade.ReactElement*
  ): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](
    `type`: ClassType[P, T, C],
    props: js.UndefOr[scala.Nothing],
    children: slinky.core.facade.ReactElement*
  ): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C], props: Null, children: slinky.core.facade.ReactElement*): CElement[P, T] = js.native
}

