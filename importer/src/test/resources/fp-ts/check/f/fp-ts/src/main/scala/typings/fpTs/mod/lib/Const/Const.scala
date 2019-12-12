package typings.fpTs.mod.lib.Const

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fp-ts/lib/Const", "Const")
@js.native
class Const[L, A] protected () extends js.Object {
  def this(value: L) = this()
  val _A: A = js.native
  val _L: L = js.native
  val _URI: URI = js.native
  val value: L = js.native
  def contramap[B](f: js.Function1[/* b */ B, A]): typings.fpTs.mod.lib.Const.Const[L, B] = js.native
  def fold[B](f: js.Function1[/* l */ L, B]): B = js.native
  def inspect(): String = js.native
  def map[B](f: js.Function1[/* a */ A, B]): typings.fpTs.mod.lib.Const.Const[L, B] = js.native
}

