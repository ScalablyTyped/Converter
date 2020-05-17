package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.typeMappings.TextMark
  - typings.typeMappings.TrailMark
*/
trait Mark extends js.Object

object Mark {
  @scala.inline
  implicit def apply(value: TextMark): Mark = value.asInstanceOf[Mark]
  @scala.inline
  implicit def apply(value: TrailMark): Mark = value.asInstanceOf[Mark]
}

