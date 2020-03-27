package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.ComponentClassP
import org.scalajs.dom.raw.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "createFactory")
@js.native
object createFactory extends js.Object {
  def apply(`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any): SVGFactory = js.native
  def apply[P](`type`: ClassType[P, ClassicComponent[P, ComponentState], ClassicComponentClass[P]]): CFactory[P, ClassicComponent[P, js.Object]] = js.native
  def apply[P](`type`: ComponentClass[P, ComponentState]): Factory[P] = js.native
  // Custom components
  def apply[P](`type`: FunctionComponent[P]): FunctionComponentFactory[P] = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String): DOMFactory[P, T] = js.native
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: ComponentClassP[P with js.Object] */](`type`: ClassType[P, T, C]): CFactory[P, T] = js.native
}

