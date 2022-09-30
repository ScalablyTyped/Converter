package typings.prisma

import typings.prisma.prismaStrings.PrismaClientPromise
import typings.std.Promise
import typings.std.PromiseLike
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("prisma", "Prisma__ColumnClient")
  @js.native
  open class PrismaColumnClient[T] ()
    extends StObject
       with PrismaPromise[T] {
    
    def `catch`[TResult](): js.Promise[T | TResult] = js.native
    def `catch`[TResult](onrejected: js.Function1[/* reason */ Any, TResult | PromiseLike[TResult]]): js.Promise[T | TResult] = js.native
    
    def `finally`(): js.Promise[T] = js.native
    def `finally`(onfinally: js.Function0[Unit]): js.Promise[T] = js.native
    
    def `then`[TResult1, TResult2](): js.Promise[TResult1 | TResult2] = js.native
    def `then`[TResult1, TResult2](onfulfilled: js.Function1[/* value */ T, TResult1 | PromiseLike[TResult1]]): js.Promise[TResult1 | TResult2] = js.native
    def `then`[TResult1, TResult2](
      onfulfilled: js.Function1[/* value */ T, TResult1 | PromiseLike[TResult1]],
      onrejected: js.Function1[/* reason */ Any, TResult2 | PromiseLike[TResult2]]
    ): js.Promise[TResult1 | TResult2] = js.native
    def `then`[TResult1, TResult2](onfulfilled: Null, onrejected: js.Function1[/* reason */ Any, TResult2 | PromiseLike[TResult2]]): js.Promise[TResult1 | TResult2] = js.native
    def `then`[TResult1, TResult2](onfulfilled: Unit, onrejected: js.Function1[/* reason */ Any, TResult2 | PromiseLike[TResult2]]): js.Promise[TResult1 | TResult2] = js.native
    
    @JSName(js.Symbol.toStringTag)
    val toStringTag: PrismaClientPromise = js.native
  }
  
  @js.native
  trait PrismaPromise[A]
    extends StObject
       with Promise[A]
}
