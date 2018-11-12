package typings
package rxjsLib.internalTypesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Subscribable[T] extends js.Object {
  def subscribe(): Unsubscribable = js.native
  def subscribe(observerOrNext: js.Function1[/* value */ T, scala.Unit]): Unsubscribable = js.native
  def subscribe(
    observerOrNext: js.Function1[/* value */ T, scala.Unit],
    error: js.Function1[/* error */ js.Any, scala.Unit]
  ): Unsubscribable = js.native
  def subscribe(
    observerOrNext: js.Function1[/* value */ T, scala.Unit],
    error: js.Function1[/* error */ js.Any, scala.Unit],
    complete: js.Function0[scala.Unit]
  ): Unsubscribable = js.native
  def subscribe(observerOrNext: PartialObserver[T]): Unsubscribable = js.native
  def subscribe(observerOrNext: PartialObserver[T], error: js.Function1[/* error */ js.Any, scala.Unit]): Unsubscribable = js.native
  def subscribe(
    observerOrNext: PartialObserver[T],
    error: js.Function1[/* error */ js.Any, scala.Unit],
    complete: js.Function0[scala.Unit]
  ): Unsubscribable = js.native
}

