package typings.vue.optionsMod

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
  @scala.inline
  implicit class PropOptionsOps[Self[t] <: PropOptions[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withDefaultFunction0(default: () => js.Object): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("default")(js.Any.fromFunction0(default))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDefault(default: T | js.Function0[js.Object]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (default != null) ret.updateDynamic("default")(default.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDefault: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "default")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRequired(required: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(required)) ret.updateDynamic("required")(required.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRequired: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "required")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTypeFunction0(`type`: () => T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("type")(js.Any.fromFunction0(`type`))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withType(`type`: Prop[T] | js.Array[Prop[T]]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (`type` != null) ret.updateDynamic("type")(`type`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutType: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "type")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withValidator(validator: /* value */ T => Boolean): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (validator != null) ret.updateDynamic("validator")(js.Any.fromFunction1(validator))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutValidator: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "validator")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

