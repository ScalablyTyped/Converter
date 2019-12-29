package typings.vue.typesOptionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait PropOptions[T] extends js.Object {
  var default: js.UndefOr[T | Null | js.Function0[js.Object]] = js.native
  var required: js.UndefOr[Boolean] = js.native
  var `type`: js.UndefOr[Prop[T] | js.Array[Prop[T]]] = js.native
  var validator: js.UndefOr[js.Function1[/* value */ T, Boolean]] = js.native
}

object PropOptions {
  @scala.inline
  def apply[T](
    default: T | js.Function0[js.Object] = null,
    required: js.UndefOr[Boolean] = js.undefined,
    `type`: Prop[T] | js.Array[Prop[T]] = null,
    validator: /* value */ T => Boolean = null
  ): PropOptions[T] = {
    val __obj = js.Dynamic.literal()
    if (default != null) __obj.updateDynamic("default")(default.asInstanceOf[js.Any])
    if (!js.isUndefined(required)) __obj.updateDynamic("required")(required.asInstanceOf[js.Any])
    if (`type` != null) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (validator != null) __obj.updateDynamic("validator")(js.Any.fromFunction1(validator))
    __obj.asInstanceOf[PropOptions[T]]
  }
}

