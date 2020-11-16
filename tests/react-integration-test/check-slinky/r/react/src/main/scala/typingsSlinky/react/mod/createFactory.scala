package typingsSlinky.react.mod

import org.scalajs.dom.raw.Element
import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("react", "createFactory")
@js.native
object createFactory extends js.Object {
  
  def apply(`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any): SVGFactory = js.native
  def apply[P](`type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]]): CFactory[P, ReactComponentClass[P]] = js.native
  def apply[P](`type`: ComponentClass[P, js.Object]): Factory[P] = js.native
  // Custom components
  def apply[P](`type`: FunctionComponent[P]): FunctionComponentFactory[P] = js.native
  def apply[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String): DOMFactory[P, T] = js.native
  def apply[P, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C]): CFactory[P, T] = js.native
}
