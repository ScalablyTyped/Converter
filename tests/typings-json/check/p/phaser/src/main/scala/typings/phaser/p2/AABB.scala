package typings.phaser.p2

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AABB extends js.Object {
  def copy(aabb: AABB): Unit = js.native
}

object AABB {
  @scala.inline
  def apply(copy: AABB => Unit): AABB = {
    val __obj = js.Dynamic.literal(copy = js.Any.fromFunction1(copy))
    __obj.asInstanceOf[AABB]
  }
  @scala.inline
  implicit class AABBOps[Self <: AABB] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCopy(value: AABB => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("copy")(js.Any.fromFunction1(value))
        ret
    }
  }
  
}

