package typings.vue.typesOptionsMod

import org.scalablytyped.runtime.NullUndefOr
import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait PropOptions[T] extends _PropValidator[T] {
  var default: NullUndefOr[T | js.Function0[js.Object]] = js.undefined
  var required: UndefOr[Boolean] = js.undefined
  var `type`: UndefOr[Prop[T] | js.Array[Prop[T]]] = js.undefined
  var validator: UndefOr[js.Function1[/* value */ T, Boolean]] = js.undefined
}

object PropOptions {
  @scala.inline
  def apply[T](
    default: T | js.Function0[js.Object] = null,
    required: `<undefined>` | Boolean = js.undefined,
    `type`: Prop[T] | js.Array[Prop[T]] = null,
    validator: /* value */ T => Boolean = null
  ): PropOptions[T] = {
    val __obj = js.Dynamic.literal()
    if (default != null) __obj.updateDynamic("default")(default.asInstanceOf[js.Any])
    if (!js.isUndefined(required)) __obj.updateDynamic("required")(required)
    if (`type` != null) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (validator != null) __obj.updateDynamic("validator")(js.Any.fromFunction1(validator))
    __obj.asInstanceOf[PropOptions[T]]
  }
}

