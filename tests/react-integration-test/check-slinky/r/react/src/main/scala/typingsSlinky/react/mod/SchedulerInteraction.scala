package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/**
  * defined in scheduler/tracing
  */
@js.native
trait SchedulerInteraction extends js.Object {
  var id: Double = js.native
  var name: String = js.native
  var timestamp: Double = js.native
}

object SchedulerInteraction {
  @scala.inline
  def apply(id: Double, name: String, timestamp: Double): SchedulerInteraction = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], timestamp = timestamp.asInstanceOf[js.Any])
    __obj.asInstanceOf[SchedulerInteraction]
  }
}

