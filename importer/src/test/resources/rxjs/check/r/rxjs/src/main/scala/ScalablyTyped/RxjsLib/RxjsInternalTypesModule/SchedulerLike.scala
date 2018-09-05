package ScalablyTyped
package RxjsLib.RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SchedulerLike extends js.Object {
  def now(): scala.Double = js.native
  def schedule[T](work: js.ThisFunction1[/* this */ SchedulerAction[T], /* state */ js.UndefOr[T], scala.Unit]): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
  def schedule[T](work: js.ThisFunction1[/* this */ SchedulerAction[T], /* state */ js.UndefOr[T], scala.Unit], delay: scala.Double): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
  def schedule[T](work: js.ThisFunction1[/* this */ SchedulerAction[T], /* state */ js.UndefOr[T], scala.Unit], delay: scala.Double, state: T): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
}

