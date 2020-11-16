package typings.fpTs.constMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("fp-ts/lib/Const", "Const")
@js.native
class Const[L, A] protected () extends js.Object {
  def this(value: L) = this()
  
  val _A: A = js.native
  
  val _L: L = js.native
  
  val _URI: URI = js.native
  
  def contramap[B](f: js.Function1[/* b */ B, A]): Const[L, B] = js.native
  
  def fold[B](f: js.Function1[/* l */ L, B]): B = js.native
  
  def inspect(): String = js.native
  
  def map[B](f: js.Function1[/* a */ A, B]): Const[L, B] = js.native
  
  val value: L = js.native
}
