package typings.elasticsearchJs

import typings.std.Promise
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  trait TransportRequestPromise[T]
    extends StObject
       with Promise[T] {
    
    def abort(): Unit
  }
  object TransportRequestPromise {
    
    inline def apply[T](abort: () => Unit): TransportRequestPromise[T] = {
      val __obj = js.Dynamic.literal(abort = js.Any.fromFunction0(abort))
      __obj.asInstanceOf[TransportRequestPromise[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: TransportRequestPromise[?], T] (val x: Self & TransportRequestPromise[T]) extends AnyVal {
      
      inline def setAbort(value: () => Unit): Self = StObject.set(x, "abort", js.Any.fromFunction0(value))
    }
  }
}
