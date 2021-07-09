package typings.tstl

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object std {
  
  @js.native
  trait Queue_[T] extends StObject {
    
    var container_ : js.Any = js.native
    
    def empty(): Boolean = js.native
  }
  object Queue_ {
    
    @scala.inline
    def apply[T](container_ : js.Any, empty: () => Boolean): Queue_[T] = {
      val __obj = js.Dynamic.literal(container_ = container_.asInstanceOf[js.Any], empty = js.Any.fromFunction0(empty))
      __obj.asInstanceOf[Queue_[T]]
    }
    
    @scala.inline
    implicit class Queue_MutableBuilder[Self <: Queue_[_], T] (val x: Self with Queue_[T]) extends AnyVal {
      
      @scala.inline
      def setContainer_(value: js.Any): Self = StObject.set(x, "container_", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setEmpty(value: () => Boolean): Self = StObject.set(x, "empty", js.Any.fromFunction0(value))
    }
  }
  
  /* was `typeof Queue` */
  type queue[T] = Queue_[T]
}
