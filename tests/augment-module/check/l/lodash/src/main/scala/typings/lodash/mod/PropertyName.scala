package typings.lodash.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - java.lang.String
  - scala.Double
  - js.Symbol
*/
trait PropertyName extends js.Object

object PropertyName {
  @scala.inline
  implicit def apply(value: Double): PropertyName = value.asInstanceOf[PropertyName]
  @scala.inline
  implicit def apply(value: String): PropertyName = value.asInstanceOf[PropertyName]
  @scala.inline
  implicit def apply(value: js.Symbol): PropertyName = value.asInstanceOf[PropertyName]
}

