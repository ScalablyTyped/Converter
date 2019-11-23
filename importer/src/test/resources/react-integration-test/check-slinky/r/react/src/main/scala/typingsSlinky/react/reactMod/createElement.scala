package typingsSlinky.react.reactMod

import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.SVGElement
import slinky.core.ReactComponentClass
import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "createElement")
@js.native
object createElement extends js.Object {
  def apply[P /* <: js.Object */](`type`: String): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: String, children: ReactNode*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: String, props: Attributes with P, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: ClassType[P, ClassicComponent[P, ComponentState], ClassicComponentClass[P]]): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ClassicComponent[P, ComponentState], ClassicComponentClass[P]],
    children: ReactNode*
  ): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ClassicComponent[P, ComponentState], ClassicComponentClass[P]],
    props: (ClassAttributes[ClassicComponent[P, ComponentState]]) with P,
    children: TagMod[Any]*
  ): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState]): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState], children: ReactNode*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState], props: Attributes with P, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  // Custom components
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P]): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], children: ReactNode*): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: Attributes with P, children: TagMod[Any]*): FunctionComponentElement[P] = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String, props: ClassAttributes[T] with P, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    children: ReactNode*
  ): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: ClassAttributes[T] with P,
    children: TagMod[Any]*
  ): ReactSVGElement = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C]): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C], children: ReactNode*): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C], props: ClassAttributes[T] with P, children: TagMod[Any]*): CElement[P, T] = js.native
}

