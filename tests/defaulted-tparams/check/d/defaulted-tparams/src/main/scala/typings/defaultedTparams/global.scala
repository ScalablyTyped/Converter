package typings.defaultedTparams

import typings.std.Iterable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSGlobalScope
@js.native
object global extends js.Object {
  @js.native
  class Queue[S, T] ()
    extends typings.defaultedTparams.Queue[S, T]
  
  /* static members */
  @js.native
  object Queue extends js.Object {
    def from[T](iterable: Iterable[T]): typings.defaultedTparams.Queue[T, T] = js.native
    def from[T](iterable: Iterable[T], length: Double): typings.defaultedTparams.Queue[T, T] = js.native
  }
  
}

