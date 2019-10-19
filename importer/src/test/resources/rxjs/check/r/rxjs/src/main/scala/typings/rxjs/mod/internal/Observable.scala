package typings.rxjs.mod.internal

import typings.rxjs.mod.internal.types.OperatorFunction
import typings.rxjs.mod.internal.types.Subscribable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("rxjs/internal/Observable", JSImport.Namespace)
@js.native
object Observable extends js.Object {
  @js.native
  class Observable[T] () extends Subscribable[T] {
    /** Internal implementation detail, do not use directly. */
    var _isScalar: Boolean = js.native
    @JSName("foo")
    var foo_Original: OperatorFunction[Double, String] = js.native
    /** @deprecated This is an internal implementation detail, do not use. */
    var source: typings.rxjs.mod.internal.Observable.Observable[_] = js.native
    def foo(source: typings.rxjs.mod.internal.Observable.Observable[Double]): typings.rxjs.mod.internal.Observable.Observable[String] = js.native
    def pipe(): typings.rxjs.mod.internal.Observable.Observable[T] = js.native
  }
  
}

