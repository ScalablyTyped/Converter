package typings.bigint

import scala.scalajs.js.annotation.JSGlobal
import typings.bigint.BigInt.IRandom
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSGlobal("BigInt")
@js.native
object BigInt extends js.Object {
  def add(x: typings.bigint.BigInt.BigInt, y: typings.bigint.BigInt.BigInt): typings.bigint.BigInt.BigInt = js.native
  def setRandom(random: IRandom): Unit = js.native
  type BigInt = js.Array[Double]
  type IRandom = js.Function0[Double]
}

