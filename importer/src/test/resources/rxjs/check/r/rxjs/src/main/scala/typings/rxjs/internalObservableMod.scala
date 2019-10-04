package typings.rxjs

import typings.rxjs.internalObservableMod.Observable
import typings.rxjs.internalTypesMod.OperatorFunction
import typings.rxjs.internalTypesMod.Subscribable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("rxjs/internal/Observable", JSImport.Namespace)
@js.native
object internalObservableMod extends js.Object {
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
  
}

