package typings.elasticsearchJs

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait TransportRequestPromise[T]
    extends js.Promise[T] {
    
    def abort(): Unit = js.native
  }
  object TransportRequestPromise {
    
    @scala.inline
    def apply[T](abort: () => Unit): TransportRequestPromise[T] = {
      val __obj = js.Dynamic.literal(abort = js.Any.fromFunction0(abort))
      __obj.asInstanceOf[TransportRequestPromise[T]]
    }
    
    @scala.inline
    implicit class TransportRequestPromiseMutableBuilder[Self <: TransportRequestPromise[_], T] (val x: Self with TransportRequestPromise[T]) extends AnyVal {
      
      @scala.inline
      def setAbort(value: () => Unit): Self = StObject.set(x, "abort", js.Any.fromFunction0(value))
    }
  }
}
