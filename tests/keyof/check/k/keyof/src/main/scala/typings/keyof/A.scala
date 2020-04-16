package typings.keyof

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait A extends js.Object {
  var a: Double = js.native
  var b: Double = js.native
  var c: Double = js.native
}

object A {
  @scala.inline
  def apply(a: Double, b: Double, c: Double): A = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
    __obj.asInstanceOf[A]
  }
}

