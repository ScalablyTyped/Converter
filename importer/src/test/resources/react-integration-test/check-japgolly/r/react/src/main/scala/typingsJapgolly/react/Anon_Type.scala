package typingsJapgolly.react

import typingsJapgolly.react.reactMod.ComponentType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Anon_Type[T /* <: ComponentType[_] */] extends js.Object {
  val `type`: T = js.native
}

object Anon_Type {
  @scala.inline
  def apply[T /* <: ComponentType[_] */](`type`: T): Anon_Type[T] = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[Anon_Type[T]]
  }
}

