package typingsSlinky.react.mod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ConsumerProps[T] extends js.Object {
  var unstable_observedBits: js.UndefOr[Double] = js.native
  def children(value: T): TagMod[Any] = js.native
}

object ConsumerProps {
  @scala.inline
  def apply[T](children: T => TagMod[Any]): ConsumerProps[T] = {
    val __obj = js.Dynamic.literal(children = js.Any.fromFunction1(children))
    __obj.asInstanceOf[ConsumerProps[T]]
  }
  @scala.inline
  implicit class ConsumerPropsOps[Self <: ConsumerProps[_], T] (val x: Self with ConsumerProps[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildren(value: T => TagMod[Any]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withUnstable_observedBits(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("unstable_observedBits")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutUnstable_observedBits: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("unstable_observedBits")(js.undefined)
        ret
    }
  }
  
}

