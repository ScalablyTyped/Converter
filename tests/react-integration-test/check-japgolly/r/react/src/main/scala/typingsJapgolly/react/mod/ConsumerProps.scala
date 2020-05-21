package typingsJapgolly.react.mod

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Node
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ConsumerProps[T] extends js.Object {
  var unstable_observedBits: js.UndefOr[Double] = js.native
  def children(value: T): Node = js.native
}

object ConsumerProps {
  @scala.inline
  def apply[T](children: T => CallbackTo[Node], unstable_observedBits: Int | Double = null): ConsumerProps[T] = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("children")(js.Any.fromFunction1((t0: T) => children(t0).runNow()))
    if (unstable_observedBits != null) __obj.updateDynamic("unstable_observedBits")(unstable_observedBits.asInstanceOf[js.Any])
    __obj.asInstanceOf[ConsumerProps[T]]
  }
  @scala.inline
  implicit class ConsumerPropsOps[Self[t] <: ConsumerProps[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withChildren(children: T => CallbackTo[Node]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("children")(js.Any.fromFunction1((t0: T) => children(t0).runNow()))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnstable_observedBits(unstable_observedBits: Int | Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (unstable_observedBits != null) ret.updateDynamic("unstable_observedBits")(unstable_observedBits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnstable_observedBits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "unstable_observedBits")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

