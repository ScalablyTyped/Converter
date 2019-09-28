package typings.rxjs.internalTypesMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait SubscriptionLike extends Unsubscribable {
  val closed: Boolean
}

object SubscriptionLike {
  @inline
  def apply(closed: Boolean, unsubscribe: () => Unit): SubscriptionLike = {
    val __obj = js.Dynamic.literal(closed = closed, unsubscribe = js.Any.fromFunction0(unsubscribe))
  
    __obj.asInstanceOf[SubscriptionLike]
  }
}

