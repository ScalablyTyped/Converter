package typings.cldrjs.cldrjsMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait TimeDataStatic extends js.Object {
  def allowed(): String
  def preferred(): String
}

object TimeDataStatic {
  @inline
  def apply(allowed: () => String, preferred: () => String): TimeDataStatic = {
    val __obj = js.Dynamic.literal(allowed = js.Any.fromFunction0(allowed), preferred = js.Any.fromFunction0(preferred))
  
    __obj.asInstanceOf[TimeDataStatic]
  }
}

