package typings.elasticsearchJs

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait TransportRequestPromise[T]
    extends js.Promise[T] {
    
    def abort(): Unit = js.native
  }
  object TransportRequestPromise {
    
    @scala.inline
    def apply[T](
      abort: () => Unit,
      `catch`: js.UndefOr[js.Function1[Any, js.Any | js.Thenable[js.Any]]] => js.Promise[js.Any],
      executor: (js.Function1[T | js.Thenable[T], ?], js.Function1[Any, ?]) => ?,
      `then`: ((js.Function1[T, js.Any | js.Thenable[js.Any]]) | Unit, js.UndefOr[js.Function1[Any, js.Any | js.Thenable[js.Any]]]) => js.Promise[js.Any]
    ): TransportRequestPromise[T] = {
      val __obj = js.Dynamic.literal(abort = js.Any.fromFunction0(abort), executor = js.Any.fromFunction2(executor))
      __obj.updateDynamic("catch")(js.Any.fromFunction1(`catch`))
      __obj.updateDynamic("then")(js.Any.fromFunction2(`then`))
      __obj.asInstanceOf[TransportRequestPromise[T]]
    }
    
    @scala.inline
    implicit class TransportRequestPromiseMutableBuilder[Self <: TransportRequestPromise[?], T] (val x: Self & TransportRequestPromise[T]) extends AnyVal {
      
      @scala.inline
      def setAbort(value: () => Unit): Self = StObject.set(x, "abort", js.Any.fromFunction0(value))
    }
  }
}
