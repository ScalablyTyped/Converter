package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Person extends js.Object {
  var age: js.UndefOr[scala.Double | Null] = js.native
  var name: String = js.native
}

object Person {
  @scala.inline
  def apply(name: String, age: Int | scala.Double = null): Person = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    __obj.asInstanceOf[Person]
  }
}

