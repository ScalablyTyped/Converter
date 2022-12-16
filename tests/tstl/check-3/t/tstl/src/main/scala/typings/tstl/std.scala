package typings.tstl

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object std {
  
  trait Queue_[T] extends StObject {
    
    /* private */ var container_ : Any
    
    def empty(): Boolean
  }
  object Queue_ {
    
    inline def apply[T](container_ : Any, empty: () => Boolean): Queue_[T] = {
      val __obj = js.Dynamic.literal(container_ = container_.asInstanceOf[js.Any], empty = js.Any.fromFunction0(empty))
      __obj.asInstanceOf[Queue_[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Queue_[?], T] (val x: Self & Queue_[T]) extends AnyVal {
      
      inline def setContainer_(value: Any): Self = StObject.set(x, "container_", value.asInstanceOf[js.Any])
      
      inline def setEmpty(value: () => Boolean): Self = StObject.set(x, "empty", js.Any.fromFunction0(value))
    }
  }
  
  /* was `typeof Queue` */
  type queue[T] = Queue_[T]
}
