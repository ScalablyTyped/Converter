package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// React Nodes
// http://facebook.github.io/react/docs/glossary.html
// ----------------------------------------------------------------------
/* Rewritten from type alias, can be one of: 
  - java.lang.String
  - scala.Double
*/
trait ReactText extends ReactChild

object ReactText {
  @scala.inline
  implicit def apply(value: Double): ReactText = value.asInstanceOf[ReactText]
  @scala.inline
  implicit def apply(value: String): ReactText = value.asInstanceOf[ReactText]
}

