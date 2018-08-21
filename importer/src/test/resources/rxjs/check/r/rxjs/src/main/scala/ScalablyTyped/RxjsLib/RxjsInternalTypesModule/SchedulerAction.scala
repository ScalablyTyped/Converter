package ScalablyTyped
package RxjsLib
package RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SchedulerAction[T] extends RxjsLib.RxjsInternalSubscriptionModule.Subscription {
  def schedule(): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
  def schedule(state: T): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
  def schedule(state: T, delay: scala.Double): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
}

