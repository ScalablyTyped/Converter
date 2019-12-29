package typings.typeDashMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Anon_AgeName extends js.Object {
  var age: Double = js.native
  var name: String = js.native
}

object Anon_AgeName {
  @scala.inline
  def apply(age: Double, name: String): Anon_AgeName = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Anon_AgeName]
  }
}

