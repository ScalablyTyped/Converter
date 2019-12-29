package typings.cldrjs.cldrjsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TimeDataStatic extends js.Object {
  def allowed(): String = js.native
  def preferred(): String = js.native
}

object TimeDataStatic {
  @scala.inline
  def apply(allowed: () => String, preferred: () => String): TimeDataStatic = {
    val __obj = js.Dynamic.literal(allowed = js.Any.fromFunction0(allowed), preferred = js.Any.fromFunction0(preferred))
  
    __obj.asInstanceOf[TimeDataStatic]
  }
}

