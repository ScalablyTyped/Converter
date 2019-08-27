package typings.vue

import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_Event extends js.Object {
  var event: UndefOr[String] = js.undefined
  var prop: UndefOr[String] = js.undefined
}

object Anon_Event {
  @scala.inline
  def apply(event: String = null, prop: String = null): Anon_Event = {
    val __obj = js.Dynamic.literal()
    if (event != null) __obj.updateDynamic("event")(event)
    if (prop != null) __obj.updateDynamic("prop")(prop)
    __obj.asInstanceOf[Anon_Event]
  }
}

