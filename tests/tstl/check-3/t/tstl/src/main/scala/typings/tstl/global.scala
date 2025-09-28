package typings.tstl

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object std {
    
    @JSGlobal("std")
    @js.native
    val ^ : js.Any = js.native
    
    @JSGlobal("std.Queue")
    @js.native
    open class Queue_[T] ()
      extends StObject
         with typings.tstl.std.Queue_[T] {
      def this(container: typings.tstl.std.Queue_[T]) = this()
      
      /* private */ /* CompleteClass */
      var container_ : Any = js.native
      
      /* CompleteClass */
      override def empty(): Boolean = js.native
    }
    
    @JSGlobal("std.queue")
    @js.native
    def queue: Instantiable0[typings.tstl.std.Queue_[js.Object]] = js.native
    
    /* This class was inferred from a value with a constructor, it was renamed because a distinct type already exists with the same name. */
    @JSGlobal("std.queue")
    @js.native
    open class queueCls[T] ()
      extends StObject
         with typings.tstl.std.Queue_[T] {
      
      /* private */ /* CompleteClass */
      var container_ : Any = js.native
      
      /* CompleteClass */
      override def empty(): Boolean = js.native
    }
    
    inline def queue_=(x: Instantiable0[typings.tstl.std.Queue_[js.Object]]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("queue")(x.asInstanceOf[js.Any])
  }
}
