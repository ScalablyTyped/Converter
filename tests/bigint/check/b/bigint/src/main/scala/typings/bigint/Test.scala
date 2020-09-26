package typings.bigint

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Test extends js.Object {
  var a: js.BigInt = js.native
  var b: js.BigInt = js.native
  var c: typings.bigint.BigInt.BigInt = js.native
}

object Test {
  @scala.inline
  def apply(a: js.BigInt, b: js.BigInt, c: typings.bigint.BigInt.BigInt): Test = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
    __obj.asInstanceOf[Test]
  }
  @scala.inline
  implicit class TestOps[Self <: Test] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setA(value: js.BigInt): Self = this.set("a", value.asInstanceOf[js.Any])
    @scala.inline
    def setB(value: js.BigInt): Self = this.set("b", value.asInstanceOf[js.Any])
    @scala.inline
    def setCVarargs(value: Double*): Self = this.set("c", js.Array(value :_*))
    @scala.inline
    def setC(value: typings.bigint.BigInt.BigInt): Self = this.set("c", value.asInstanceOf[js.Any])
  }
  
}

