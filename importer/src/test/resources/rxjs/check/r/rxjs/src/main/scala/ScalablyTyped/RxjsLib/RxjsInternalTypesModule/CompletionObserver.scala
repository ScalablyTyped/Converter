package ScalablyTyped
package RxjsLib
package RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait CompletionObserver[T] extends js.Object {
  val closed: js.UndefOr[scala.Boolean] = js.undefined
  val error: js.UndefOr[js.Function1[/* err */ js.Any, scala.Unit]] = js.undefined
  val next: js.UndefOr[js.Function1[/* value */ T, scala.Unit]] = js.undefined
  def complete(): scala.Unit
}

