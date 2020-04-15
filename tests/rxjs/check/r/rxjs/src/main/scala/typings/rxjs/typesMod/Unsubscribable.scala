package typings.rxjs.typesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Unsubscribable extends js.Object {
  def unsubscribe(): Unit = js.native
}

object Unsubscribable {
  @scala.inline
  def apply(unsubscribe: () => Unit): Unsubscribable = {
    val __obj = js.Dynamic.literal(unsubscribe = js.Any.fromFunction0(unsubscribe))
    __obj.asInstanceOf[Unsubscribable]
  }
}

