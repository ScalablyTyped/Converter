package ScalablyTyped
package RxjsLib.RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait NextObserver[T] extends js.Object {
  val closed: js.UndefOr[scala.Boolean] = js.undefined
  val complete: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val error: js.UndefOr[js.Function1[/* err */ js.Any, scala.Unit]] = js.undefined
  def next(value: T): scala.Unit
}

