package typings.vue.typesOptionsMod

import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait WatchOptions extends js.Object {
  var deep: UndefOr[Boolean] = js.undefined
  var immediate: UndefOr[Boolean] = js.undefined
}

object WatchOptions {
  @scala.inline
  def apply(deep: `<undefined>` | Boolean = js.undefined, immediate: `<undefined>` | Boolean = js.undefined): WatchOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(deep)) __obj.updateDynamic("deep")(deep)
    if (!js.isUndefined(immediate)) __obj.updateDynamic("immediate")(immediate)
    __obj.asInstanceOf[WatchOptions]
  }
}

