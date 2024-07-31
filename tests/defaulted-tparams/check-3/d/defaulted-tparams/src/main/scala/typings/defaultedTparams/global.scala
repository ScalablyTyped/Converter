package typings.defaultedTparams

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @JSGlobal("Queue")
  @js.native
  open class Queue[S, T] ()
    extends StObject
       with _root_.typings.defaultedTparams.Queue[S, T] {
    
    /**
      * Whether the queue is empty
      */
    /* CompleteClass */
    override val empty: Boolean = js.native
    
    /**
      * Whether the queue is full
      */
    /* CompleteClass */
    override val full: Boolean = js.native
    
    /**
      * The length of the queue
      */
    /* CompleteClass */
    override val length: Double = js.native
    
    /**
      * Removes and returns an element from the beginning
      */
    /* CompleteClass */
    override def pop(): js.UndefOr[T] = js.native
    
    /**
      * Inserts a new element at the end
      */
    /* CompleteClass */
    override def push(x: S): this.type = js.native
  }
  object Queue {
    
    @JSGlobal("Queue")
    @js.native
    val ^ : js.Any = js.native
    
    /* static member */
    inline def from[T](iterable: js.Iterable[T]): _root_.typings.defaultedTparams.Queue[T, T] = ^.asInstanceOf[js.Dynamic].applyDynamic("from")(iterable.asInstanceOf[js.Any]).asInstanceOf[_root_.typings.defaultedTparams.Queue[T, T]]
    inline def from[T](iterable: js.Iterable[T], length: Double): _root_.typings.defaultedTparams.Queue[T, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("from")(iterable.asInstanceOf[js.Any], length.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.defaultedTparams.Queue[T, T]]
  }
}
