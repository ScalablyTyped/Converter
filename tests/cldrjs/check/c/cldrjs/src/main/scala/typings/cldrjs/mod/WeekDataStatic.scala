package typings.cldrjs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait WeekDataStatic extends js.Object {
  def firstDay(): String = js.native
  def minDays(): Double = js.native
}

object WeekDataStatic {
  @scala.inline
  def apply(firstDay: () => String, minDays: () => Double): WeekDataStatic = {
    val __obj = js.Dynamic.literal(firstDay = js.Any.fromFunction0(firstDay), minDays = js.Any.fromFunction0(minDays))
  
    __obj.asInstanceOf[WeekDataStatic]
  }
}

