package typings.vue.typesOptionsMod

import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ComputedOptions[T] extends js.Object {
  var cache: UndefOr[Boolean] = js.undefined
  var get: UndefOr[js.Function0[T]] = js.undefined
  var set: UndefOr[js.Function1[/* value */ T, Unit]] = js.undefined
}

object ComputedOptions {
  @scala.inline
  def apply[T](
    cache: `<undefined>` | Boolean = js.undefined,
    get: () => T = null,
    set: /* value */ T => Unit = null
  ): ComputedOptions[T] = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(cache)) __obj.updateDynamic("cache")(cache)
    if (get != null) __obj.updateDynamic("get")(js.Any.fromFunction0(get))
    if (set != null) __obj.updateDynamic("set")(js.Any.fromFunction1(set))
    __obj.asInstanceOf[ComputedOptions[T]]
  }
}

