package typings.expandTypeParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait B extends TA {
  var b: String = js.native
}

object B {
  @scala.inline
  def apply(b: String): B = {
    val __obj = js.Dynamic.literal(b = b.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[B]
  }
}

