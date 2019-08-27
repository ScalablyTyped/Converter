package typings.typeDashMappings

import org.scalablytyped.runtime.NullUndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Person extends js.Object {
  var age: NullUndefOr[Double] = js.undefined
  var name: String
}

object Person {
  @scala.inline
  def apply(name: String, age: Int | Double = null): Person = {
    val __obj = js.Dynamic.literal(name = name)
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    __obj.asInstanceOf[Person]
  }
}

