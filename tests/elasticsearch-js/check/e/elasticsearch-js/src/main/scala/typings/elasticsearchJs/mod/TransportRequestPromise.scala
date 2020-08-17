package typings.elasticsearchJs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TransportRequestPromise[T]
  extends js.Promise[T] {
  def abort(): Unit = js.native
}

object TransportRequestPromise {
  @scala.inline
  def apply[T](abort: () => Unit): TransportRequestPromise[T] = {
    val __obj = js.Dynamic.literal(abort = js.Any.fromFunction0(abort))
    __obj.asInstanceOf[TransportRequestPromise[T]]
  }
  @scala.inline
  implicit class TransportRequestPromiseOps[Self <: TransportRequestPromise[_], T] (val x: Self with TransportRequestPromise[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setAbort(value: () => Unit): Self = this.set("abort", js.Any.fromFunction0(value))
  }
  
}

