package ScalablyTyped
package RxjsLib
package RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SchedulerLike extends js.Object {
  def now(): scala.Double = js.native
  def schedule[T](work: js.Function2[/* this */ RxjsLib.RxjsInternalTypesModule.SchedulerAction[T], /* state */ js.UndefOr[T], scala.Unit]): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
  def schedule[T](work: js.Function2[/* this */ RxjsLib.RxjsInternalTypesModule.SchedulerAction[T], /* state */ js.UndefOr[T], scala.Unit], delay: scala.Double): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
  def schedule[T](work: js.Function2[/* this */ RxjsLib.RxjsInternalTypesModule.SchedulerAction[T], /* state */ js.UndefOr[T], scala.Unit], delay: scala.Double, state: T): RxjsLib.RxjsInternalSubscriptionModule.Subscription = js.native
}

