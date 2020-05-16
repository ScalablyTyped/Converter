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
  def apply[T](cache: js.UndefOr[Boolean] = js.undefined, get: () => T = null, set: /* value */ T => Unit = null): ComputedOptions[T] = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(cache)) __obj.updateDynamic("cache")(cache.asInstanceOf[js.Any])
    if (get != null) __obj.updateDynamic("get")(js.Any.fromFunction0(get))
    if (set != null) __obj.updateDynamic("set")(js.Any.fromFunction1(set))
    __obj.asInstanceOf[ComputedOptions[T]]
  }
  @scala.inline
  implicit class ComputedOptionsOps[Self[t] <: ComputedOptions[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withCache(cache: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(cache)) ret.updateDynamic("cache")(cache.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutCache: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "cache")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGet(get: () => T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (get != null) ret.updateDynamic("get")(js.Any.fromFunction0(get))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutGet: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "get")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSet(set: /* value */ T => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (set != null) ret.updateDynamic("set")(js.Any.fromFunction1(set))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSet: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "set")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

