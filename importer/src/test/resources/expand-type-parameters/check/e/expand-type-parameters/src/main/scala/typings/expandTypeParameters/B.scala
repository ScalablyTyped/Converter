package typings.expandTypeParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait B extends TA {
  var b: String
}

object B {
  @scala.inline
  def apply(b: String): B = {
    val __obj = js.Dynamic.literal(b = b.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[B]
  }
}

