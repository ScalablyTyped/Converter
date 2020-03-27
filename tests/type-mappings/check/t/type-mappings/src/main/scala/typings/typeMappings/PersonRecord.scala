package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Record<'name' | 'age', string> */
@js.native
trait PersonRecord extends js.Object {
  var age: String = js.native
  var name: String = js.native
}

object PersonRecord {
  @scala.inline
  def apply(age: String, name: String): PersonRecord = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[PersonRecord]
  }
}

