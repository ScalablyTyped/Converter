package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<{  name  :string,   age  :number}, 'age'> */
@js.native
trait V extends js.Object {
  var age: Double = js.native
}

object V {
  @scala.inline
  def apply(age: Double): V = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[V]
  }
}

