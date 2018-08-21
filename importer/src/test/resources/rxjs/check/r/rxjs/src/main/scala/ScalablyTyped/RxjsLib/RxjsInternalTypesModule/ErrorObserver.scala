package ScalablyTyped
package RxjsLib
package RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait ErrorObserver[T] extends js.Object {
  val closed: js.UndefOr[scala.Boolean] = js.undefined
  val complete: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val next: js.UndefOr[js.Function1[/* value */ T, scala.Unit]] = js.undefined
  def error(err: js.Any): scala.Unit
}

