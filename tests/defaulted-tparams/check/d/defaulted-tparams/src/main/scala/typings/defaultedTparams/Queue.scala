package typings.defaultedTparams

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Queue[S, T] extends StObject {
  
  /**
    * Whether the queue is empty
    */
  val empty: Boolean
  
  /**
    * Whether the queue is full
    */
  val full: Boolean
  
  /**
    * The length of the queue
    */
  val length: Double
  
  /**
    * Removes and returns an element from the beginning
    */
  def pop(): js.UndefOr[T]
  
  /**
    * Inserts a new element at the end
    */
  def push(x: S): this.type
}
object Queue {
  
  inline def apply[S, T](empty: Boolean, full: Boolean, length: Double, pop: () => js.UndefOr[T], push: S => Queue[S, T]): Queue[S, T] = {
    val __obj = js.Dynamic.literal(empty = empty.asInstanceOf[js.Any], full = full.asInstanceOf[js.Any], length = length.asInstanceOf[js.Any], pop = js.Any.fromFunction0(pop), push = js.Any.fromFunction1(push))
    __obj.asInstanceOf[Queue[S, T]]
  }
  
  extension [Self <: Queue[?, ?], S, T](x: Self & (Queue[S, T])) {
    
    inline def setEmpty(value: Boolean): Self = StObject.set(x, "empty", value.asInstanceOf[js.Any])
    
    inline def setFull(value: Boolean): Self = StObject.set(x, "full", value.asInstanceOf[js.Any])
    
    inline def setLength(value: Double): Self = StObject.set(x, "length", value.asInstanceOf[js.Any])
    
    inline def setPop(value: () => js.UndefOr[T]): Self = StObject.set(x, "pop", js.Any.fromFunction0(value))
    
    inline def setPush(value: S => Queue[S, T]): Self = StObject.set(x, "push", js.Any.fromFunction1(value))
  }
}
