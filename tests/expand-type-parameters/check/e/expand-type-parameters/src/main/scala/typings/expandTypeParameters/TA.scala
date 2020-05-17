package typings.expandTypeParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.expandTypeParameters.A
  - typings.expandTypeParameters.B
  - typings.expandTypeParameters.expandTypeParametersStrings.c
*/
trait TA extends js.Object

object TA {
  @scala.inline
  def c: typings.expandTypeParameters.expandTypeParametersStrings.c = "c".asInstanceOf[typings.expandTypeParameters.expandTypeParametersStrings.c]
  @scala.inline
  implicit def apply(value: A): TA = value.asInstanceOf[TA]
  @scala.inline
  implicit def apply(value: B): TA = value.asInstanceOf[TA]
}

