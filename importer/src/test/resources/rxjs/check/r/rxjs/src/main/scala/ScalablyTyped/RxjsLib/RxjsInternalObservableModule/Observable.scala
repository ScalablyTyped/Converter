package ScalablyTyped
package RxjsLib
package RxjsInternalObservableModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("rxjs/internal/Observable", "Observable")
@js.native
class Observable[T] () extends RxjsLib.RxjsInternalTypesModule.Subscribable[T] {
  /** Internal implementation detail, do not use directly. */
  var _isScalar: scala.Boolean = js.native
  var foo: RxjsLib.RxjsInternalTypesModule.OperatorFunction[scala.Double, java.lang.String] = js.native
  /** @deprecated This is an internal implementation detail, do not use. */
  var source: RxjsLib.RxjsInternalObservableModule.Observable[_] = js.native
  def pipe(): RxjsLib.RxjsInternalObservableModule.Observable[T] = js.native
}

