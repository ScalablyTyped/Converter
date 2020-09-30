package typings.rxjs.typesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Subscribable[T] extends js.Object {
  def subscribe(): Unsubscribable = js.native
  def subscribe(
    observerOrNext: js.UndefOr[scala.Nothing],
    error: js.UndefOr[scala.Nothing],
    complete: js.Function0[Unit]
  ): Unsubscribable = js.native
  def subscribe(observerOrNext: js.UndefOr[scala.Nothing], error: js.Function1[/* error */ js.Any, Unit]): Unsubscribable = js.native
  def subscribe(
    observerOrNext: js.UndefOr[scala.Nothing],
    error: js.Function1[/* error */ js.Any, Unit],
    complete: js.Function0[Unit]
  ): Unsubscribable = js.native
  def subscribe(observerOrNext: js.Function1[/* value */ T, Unit]): Unsubscribable = js.native
  def subscribe(
    observerOrNext: js.Function1[/* value */ T, Unit],
    error: js.UndefOr[scala.Nothing],
    complete: js.Function0[Unit]
  ): Unsubscribable = js.native
  def subscribe(observerOrNext: js.Function1[/* value */ T, Unit], error: js.Function1[/* error */ js.Any, Unit]): Unsubscribable = js.native
  def subscribe(
    observerOrNext: js.Function1[/* value */ T, Unit],
    error: js.Function1[/* error */ js.Any, Unit],
    complete: js.Function0[Unit]
  ): Unsubscribable = js.native
  def subscribe(observerOrNext: PartialObserver[T]): Unsubscribable = js.native
  def subscribe(observerOrNext: PartialObserver[T], error: js.UndefOr[scala.Nothing], complete: js.Function0[Unit]): Unsubscribable = js.native
  def subscribe(observerOrNext: PartialObserver[T], error: js.Function1[/* error */ js.Any, Unit]): Unsubscribable = js.native
  def subscribe(
    observerOrNext: PartialObserver[T],
    error: js.Function1[/* error */ js.Any, Unit],
    complete: js.Function0[Unit]
  ): Unsubscribable = js.native
}

