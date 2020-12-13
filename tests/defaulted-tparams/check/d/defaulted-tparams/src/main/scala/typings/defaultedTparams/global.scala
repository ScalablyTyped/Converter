package typings.defaultedTparams

import typings.std.Iterable
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @JSGlobal("Queue")
  @js.native
  class Queue[S, T] ()
    extends typings.defaultedTparams.Queue[S, T]
  /* static members */
  object Queue {
    
    @JSGlobal("Queue.from")
    @js.native
    def from[T](iterable: Iterable[T]): typings.defaultedTparams.Queue[T, T] = js.native
    @JSGlobal("Queue.from")
    @js.native
    def from[T](iterable: Iterable[T], length: Double): typings.defaultedTparams.Queue[T, T] = js.native
  }
}
