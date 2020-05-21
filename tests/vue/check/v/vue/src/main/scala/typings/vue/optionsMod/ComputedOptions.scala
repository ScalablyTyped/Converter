package typings.vue.optionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComputedOptions[T] extends js.Object {
  var cache: js.UndefOr[Boolean] = js.native
  var get: js.UndefOr[js.Function0[T]] = js.native
  var set: js.UndefOr[js.Function1[/* value */ T, Unit]] = js.native
}

object ComputedOptions {
  @scala.inline
  def apply[T](): ComputedOptions[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ComputedOptions[T]]
  }
  @scala.inline
  implicit class ComputedOptionsOps[Self <: ComputedOptions[_], T] (val x: Self with ComputedOptions[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCache(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cache")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutCache: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("cache")(js.undefined)
        ret
    }
    @scala.inline
    def withGet(value: () => T): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("get")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutGet: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("get")(js.undefined)
        ret
    }
    @scala.inline
    def withSet(value: /* value */ T => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("set")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withoutSet: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("set")(js.undefined)
        ret
    }
  }
  
}

