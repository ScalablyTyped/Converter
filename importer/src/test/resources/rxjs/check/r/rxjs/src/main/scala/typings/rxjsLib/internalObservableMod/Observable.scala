package typings.rxjsLib.internalObservableMod

import typings.rxjsLib.internalTypesMod.OperatorFunction
import typings.rxjsLib.internalTypesMod.Subscribable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("rxjs/internal/Observable", "Observable")
@js.native
class Observable[T] () extends Subscribable[T] {
  /** Internal implementation detail, do not use directly. */
  var _isScalar: Boolean = js.native
  @JSName("foo")
  var foo_Original: OperatorFunction[Double, String] = js.native
  /** @deprecated This is an internal implementation detail, do not use. */
  var source: Observable[_] = js.native
  def foo(source: Observable[Double]): Observable[String] = js.native
  def pipe(): Observable[T] = js.native
}

