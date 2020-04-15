package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonAge extends js.Object {
  var age: Double = js.native
}

object AnonAge {
  @scala.inline
  def apply(age: Double): AnonAge = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonAge]
  }
}

