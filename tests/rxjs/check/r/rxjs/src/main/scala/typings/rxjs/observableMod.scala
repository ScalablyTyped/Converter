package typings.rxjs

import typings.rxjs.typesMod.OperatorFunction
import typings.rxjs.typesMod.Subscribable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("rxjs/internal/Observable", JSImport.Namespace)
@js.native
object observableMod extends js.Object {
  @js.native
  class Observable[T] () extends Subscribable[T] {
    /** Internal implementation detail, do not use directly. */
    var _isScalar: Boolean = js.native
    def foo(source: Observable[Double]): Observable[String] = js.native
    @JSName("foo")
    var foo_Original: OperatorFunction[Double, String] = js.native
    def pipe(): Observable[T] = js.native
    /** @deprecated This is an internal implementation detail, do not use. */
    var source: Observable[_] = js.native
  }
  
}

