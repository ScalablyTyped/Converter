package typings.typeDashMappings

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Person extends js.Object {
  var age: js.UndefOr[Double | Null] = js.undefined
  var name: String
}

object Person {
  @inline
  def apply(name: String, age: Int | Double = null): Person = {
    val __obj = js.Dynamic.literal(name = name)
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    __obj.asInstanceOf[Person]
  }
}

