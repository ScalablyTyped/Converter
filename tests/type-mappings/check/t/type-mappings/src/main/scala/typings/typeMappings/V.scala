package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<{  name  :string,   age  :number}, 'age'> */
@js.native
trait V extends js.Object {
  var age: scala.Double = js.native
}

object V {
  @scala.inline
  def apply(age: scala.Double): V = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
    __obj.asInstanceOf[V]
  }
}

