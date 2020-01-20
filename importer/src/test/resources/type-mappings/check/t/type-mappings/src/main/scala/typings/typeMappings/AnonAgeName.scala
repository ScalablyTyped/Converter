package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonAgeName extends js.Object {
  var age: Double = js.native
  var name: String = js.native
}

object AnonAgeName {
  @scala.inline
  def apply(age: Double, name: String): AnonAgeName = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[AnonAgeName]
  }
}

