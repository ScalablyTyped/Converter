package typings.bigint

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("BigInt")
@js.native
object BigInt extends js.Object {
  type BigInt = js.Array[Double]
  type IRandom = js.Function0[Double]

  trait Test extends js.Object {
    var a: js.BigInt
    var b: BigInt
    var c: BigInt.BigInt
  }
}

