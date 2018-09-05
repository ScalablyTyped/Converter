package ScalablyTyped
package RxjsLib.RxjsInternalObservableModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("rxjs/internal/Observable", "Observable")
@js.native
class Observable[T] () extends RxjsLib.RxjsInternalTypesModule.Subscribable[T] {
  /** Internal implementation detail, do not use directly. */
  val _isScalar: scala.Boolean = js.native
  val foo: RxjsLib.RxjsInternalTypesModule.OperatorFunction[scala.Double, java.lang.String] = js.native
  /** @deprecated This is an internal implementation detail, do not use. */
  val source: Observable[_] = js.native
  def pipe(): Observable[T] = js.native
}

