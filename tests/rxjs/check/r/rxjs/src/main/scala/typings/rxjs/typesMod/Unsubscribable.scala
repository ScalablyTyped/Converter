package typings.rxjs.typesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Unsubscribable extends js.Object {
  def unsubscribe(): Unit = js.native
}

object Unsubscribable {
  @scala.inline
  def apply(unsubscribe: () => Unit): Unsubscribable = {
    val __obj = js.Dynamic.literal(unsubscribe = js.Any.fromFunction0(unsubscribe))
    __obj.asInstanceOf[Unsubscribable]
  }
  @scala.inline
  implicit class UnsubscribableOps[Self <: Unsubscribable] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withUnsubscribe(unsubscribe: () => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("unsubscribe")(js.Any.fromFunction0(unsubscribe))
        ret.asInstanceOf[Self]
    }
  }
  
}

