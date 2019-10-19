package typings.rxjs.mod.internal.types

import typings.rxjs.mod.internal.Subscription.Subscription
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SchedulerAction[T] extends Subscription {
  def schedule(): Subscription = js.native
  def schedule(state: T): Subscription = js.native
  def schedule(state: T, delay: Double): Subscription = js.native
}

