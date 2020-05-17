package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// React Hooks
// ----------------------------------------------------------------------
// based on the code in https://github.com/facebook/react/pull/13968
// Unlike the class component setState, the updates are not allowed to be partial
/* Rewritten from type alias, can be one of: 
  - S
  - js.Function1[/ * prevState * / S, S]
*/
trait SetStateAction[S] extends js.Object

object SetStateAction {
  @scala.inline
  implicit def apply[S](value: js.Function1[/* prevState */ S, S]): SetStateAction[S] = value.asInstanceOf[SetStateAction[S]]
  @scala.inline
  implicit def apply[S](value: S): SetStateAction[S] = value.asInstanceOf[SetStateAction[S]]
}

