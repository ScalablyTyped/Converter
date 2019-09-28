package typings.rxjs.internalTypesMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Unsubscribable extends js.Object {
  def unsubscribe(): Unit
}

object Unsubscribable {
  @inline
  def apply(unsubscribe: () => Unit): Unsubscribable = {
    val __obj = js.Dynamic.literal(unsubscribe = js.Any.fromFunction0(unsubscribe))
  
    __obj.asInstanceOf[Unsubscribable]
  }
}

