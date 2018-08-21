package ScalablyTyped
package RxjsLib
package RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Subscribable[T] extends js.Object {
  def subscribe(): RxjsLib.RxjsInternalTypesModule.Unsubscribable = js.native
  def subscribe(observerOrNext: RxjsLib.RxjsInternalTypesModule.PartialObserver[T]): RxjsLib.RxjsInternalTypesModule.Unsubscribable = js.native
  def subscribe(observerOrNext: RxjsLib.RxjsInternalTypesModule.PartialObserver[T], error: js.Function1[/* error */ js.Any, scala.Unit]): RxjsLib.RxjsInternalTypesModule.Unsubscribable = js.native
  def subscribe(observerOrNext: RxjsLib.RxjsInternalTypesModule.PartialObserver[T], error: js.Function1[/* error */ js.Any, scala.Unit], complete: js.Function0[scala.Unit]): RxjsLib.RxjsInternalTypesModule.Unsubscribable = js.native
  def subscribe(observerOrNext: js.Function1[/* value */ T, scala.Unit]): RxjsLib.RxjsInternalTypesModule.Unsubscribable = js.native
  def subscribe(observerOrNext: js.Function1[/* value */ T, scala.Unit], error: js.Function1[/* error */ js.Any, scala.Unit]): RxjsLib.RxjsInternalTypesModule.Unsubscribable = js.native
  def subscribe(observerOrNext: js.Function1[/* value */ T, scala.Unit], error: js.Function1[/* error */ js.Any, scala.Unit], complete: js.Function0[scala.Unit]): RxjsLib.RxjsInternalTypesModule.Unsubscribable = js.native
}

