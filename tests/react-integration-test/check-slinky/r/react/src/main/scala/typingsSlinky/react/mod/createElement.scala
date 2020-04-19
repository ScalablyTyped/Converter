package typingsSlinky.react.mod

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
  def apply[P /* <: js.Object */](`type`: String, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: String, props: Attributes with P, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]]): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](`type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]], children: TagMod[Any]*): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](
    `type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]],
    props: ClassAttributes[ReactComponentClass[P]] with P,
    children: TagMod[Any]*
  ): CElement[P, ReactComponentClass[P]] = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, js.Object]): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, js.Object], children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: js.Object */](`type`: ComponentClass[P, js.Object], props: Attributes with P, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  // Custom components
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P]): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], children: TagMod[Any]*): FunctionComponentElement[P] = js.native
  def apply[P /* <: js.Object */](`type`: FunctionComponent[P], props: Attributes with P, children: TagMod[Any]*): FunctionComponentElement[P] = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String, props: ClassAttributes[T] with P, children: TagMod[Any]*): slinky.core.facade.ReactElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    children: TagMod[Any]*
  ): ReactSVGElement = js.native
  def apply[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: ClassAttributes[T] with P,
    children: TagMod[Any]*
  ): ReactSVGElement = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C]): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C], children: TagMod[Any]*): CElement[P, T] = js.native
  def apply[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C], props: ClassAttributes[T] with P, children: TagMod[Any]*): CElement[P, T] = js.native
}

