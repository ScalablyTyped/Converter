package typings.defaultedTparams

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Queue[S, T] extends StObject {
  
  /**
    * Whether the queue is empty
    */
  val empty: Boolean = js.native
  
  /**
    * Whether the queue is full
    */
  val full: Boolean = js.native
  
  /**
    * The length of the queue
    */
  val length: Double = js.native
  
  /**
    * Removes and returns an element from the beginning
    */
  def pop(): js.UndefOr[T] = js.native
  
  /**
    * Inserts a new element at the end
    */
  def push(x: S): this.type = js.native
}
object Queue {
  
  @scala.inline
  def apply[S, T](empty: Boolean, full: Boolean, length: Double, pop: () => js.UndefOr[T], push: S => Queue[S, T]): Queue[S, T] = {
    val __obj = js.Dynamic.literal(empty = empty.asInstanceOf[js.Any], full = full.asInstanceOf[js.Any], length = length.asInstanceOf[js.Any], pop = js.Any.fromFunction0(pop), push = js.Any.fromFunction1(push))
    __obj.asInstanceOf[Queue[S, T]]
  }
  
  @scala.inline
  implicit class QueueMutableBuilder[Self <: Queue[?, ?], S, T] (val x: Self & (Queue[S, T])) extends AnyVal {
    
    @scala.inline
    def setEmpty(value: Boolean): Self = StObject.set(x, "empty", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFull(value: Boolean): Self = StObject.set(x, "full", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setLength(value: Double): Self = StObject.set(x, "length", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setPop(value: () => js.UndefOr[T]): Self = StObject.set(x, "pop", js.Any.fromFunction0(value))
    
    @scala.inline
    def setPush(value: S => Queue[S, T]): Self = StObject.set(x, "push", js.Any.fromFunction1(value))
  }
}
