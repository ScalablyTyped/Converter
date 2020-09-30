package typings.defaultedTparams

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setEmpty(value: Boolean): Self = this.set("empty", value.asInstanceOf[js.Any])
    @scala.inline
    def setFull(value: Boolean): Self = this.set("full", value.asInstanceOf[js.Any])
    @scala.inline
    def setLength(value: Double): Self = this.set("length", value.asInstanceOf[js.Any])
    @scala.inline
    def setPop(value: () => js.UndefOr[T]): Self = this.set("pop", js.Any.fromFunction0(value))
    @scala.inline
    def setPush(value: S => Queue[S, T]): Self = this.set("push", js.Any.fromFunction1(value))
  }
  
}

