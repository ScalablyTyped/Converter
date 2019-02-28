package typings
package unionDashToDashInheritanceLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Either[L, R]
  extends Legal3[js.Any, L, R] {
  var value: R
}

object Either {
  @scala.inline
  def apply[L, R](value: R): Either[L, R] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Either[L, R]]
  }
}

