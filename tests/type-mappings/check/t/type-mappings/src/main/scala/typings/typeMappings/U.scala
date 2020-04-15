package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<{  name  :string,   age  :number}, 'name' | 'age'> */
@js.native
trait U extends js.Object {
  var age: scala.Double = js.native
  var name: String = js.native
}

object U {
  @scala.inline
  def apply(age: scala.Double, name: String): U = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[U]
  }
}

