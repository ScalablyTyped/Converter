package typings.defaultedTparams

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Queue[S, T] extends js.Object {
  /**
    * Whether the queue is empty
    */
  val empty: Boolean = js.native
  /**
    * Whether the queue is full
    */
  val full: Boolean = js.native
  /**
    * The length of the queue
    */
  val length: Double = js.native
  /**
    * Removes and returns an element from the beginning
    */
  def pop(): js.UndefOr[T] = js.native
  /**
    * Inserts a new element at the end
    */
  def push(x: S): this.type = js.native
}

object Queue {
  @scala.inline
  def apply[S, T](empty: Boolean, full: Boolean, length: Double, pop: () => js.UndefOr[T], push: S => Queue[S, T]): Queue[S, T] = {
    val __obj = js.Dynamic.literal(empty = empty.asInstanceOf[js.Any], full = full.asInstanceOf[js.Any], length = length.asInstanceOf[js.Any], pop = js.Any.fromFunction0(pop), push = js.Any.fromFunction1(push))
    __obj.asInstanceOf[Queue[S, T]]
  }
  @scala.inline
  implicit class QueueOps[Self <: Queue[_, _], S, T] (val x: Self with (Queue[S, T])) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withEmpty(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("empty")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withFull(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("full")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withLength(value: Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("length")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withPop(value: () => js.UndefOr[T]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("pop")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withPush(value: S => Queue[S, T]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("push")(js.Any.fromFunction1(value))
        ret
    }
  }
  
}

