package typings.vue

import typings.vue.typesOptionsMod.InjectKey
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Anon_Default extends js.Object {
  var default: js.UndefOr[js.Any] = js.native
  var from: js.UndefOr[InjectKey] = js.native
}

object Anon_Default {
  @scala.inline
  def apply(default: js.Any = null, from: InjectKey = null): Anon_Default = {
    val __obj = js.Dynamic.literal()
    if (default != null) __obj.updateDynamic("default")(default.asInstanceOf[js.Any])
    if (from != null) __obj.updateDynamic("from")(from.asInstanceOf[js.Any])
    __obj.asInstanceOf[Anon_Default]
  }
}

