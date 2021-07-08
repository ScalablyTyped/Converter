package typings.tstl

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object std {
    
    @JSGlobal("std.Queue")
    @js.native
    class Queue_[T] ()
      extends StObject
         with typings.tstl.std.Queue_[T] {
      def this(container: typings.tstl.std.Queue_[T]) = this()
      
      /* CompleteClass */
      var container_ : js.Any = js.native
      
      /* CompleteClass */
      override def empty(): Boolean = js.native
    }
    
    /* was `typeof Queue` */
    @JSGlobal("std.queue")
    @js.native
    class queue[T] ()
      extends StObject
         with typings.tstl.std.Queue_[T] {
      def this(container: typings.tstl.std.Queue_[T]) = this()
      
      /* CompleteClass */
      var container_ : js.Any = js.native
      
      /* CompleteClass */
      override def empty(): Boolean = js.native
    }
  }
}
