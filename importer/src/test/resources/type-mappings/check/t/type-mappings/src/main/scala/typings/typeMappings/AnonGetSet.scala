package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonGetSet extends js.Object {
  def get(): String = js.native
  def set(v: String): Unit = js.native
}

object AnonGetSet {
  @scala.inline
  def apply(get: () => String, set: String => Unit): AnonGetSet = {
    val __obj = js.Dynamic.literal(get = js.Any.fromFunction0(get), set = js.Any.fromFunction1(set))
  
    __obj.asInstanceOf[AnonGetSet]
  }
}

