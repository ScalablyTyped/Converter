package typings.rxjs.internalTypesMod

import org.scalablytyped.runtime.UndefOr
import typings.rxjs.internalSubscriptionMod.Subscription
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SchedulerLike extends js.Object {
  def now(): Double = js.native
  def schedule[T](work: js.ThisFunction1[/* this */ SchedulerAction[T], UndefOr[T], Unit]): Subscription = js.native
  def schedule[T](work: js.ThisFunction1[/* this */ SchedulerAction[T], UndefOr[T], Unit], delay: Double): Subscription = js.native
  def schedule[T](work: js.ThisFunction1[/* this */ SchedulerAction[T], UndefOr[T], Unit], delay: Double, state: T): Subscription = js.native
}

