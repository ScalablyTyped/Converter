package typings.rxjs.internalTypesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SubscriptionLike extends Unsubscribable {
  val closed: Boolean = js.native
}

object SubscriptionLike {
  @scala.inline
  def apply(closed: Boolean, unsubscribe: () => Unit): SubscriptionLike = {
    val __obj = js.Dynamic.literal(closed = closed.asInstanceOf[js.Any], unsubscribe = js.Any.fromFunction0(unsubscribe))
  
    __obj.asInstanceOf[SubscriptionLike]
  }
}

