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
  @scala.inline
  implicit class MarkingOps[Self <: Marking] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withText(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("text")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withTrail(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("trail")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

