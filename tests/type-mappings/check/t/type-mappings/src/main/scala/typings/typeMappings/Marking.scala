package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Record<type-mappings.Mark['type'], string> */
@js.native
trait Marking extends js.Object {
  var text: String = js.native
  var trail: String = js.native
}

object Marking {
  @scala.inline
  def apply(text: String, trail: String): Marking = {
    val __obj = js.Dynamic.literal(text = text.asInstanceOf[js.Any], trail = trail.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Marking]
  }
}

