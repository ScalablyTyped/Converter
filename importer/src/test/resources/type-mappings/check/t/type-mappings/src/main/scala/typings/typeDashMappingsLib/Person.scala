package typings
package typeDashMappingsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Person extends js.Object {
  var age: js.UndefOr[scala.Double | scala.Null] = js.undefined
  var name: java.lang.String
}

object Person {
  @scala.inline
  def apply(name: java.lang.String, age: scala.Int | scala.Double = null): Person = {
    val __obj = js.Dynamic.literal(name = name)
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    __obj.asInstanceOf[Person]
  }
}

