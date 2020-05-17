package typingsSlinky.react.mod

import typingsSlinky.react.anon.`0`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/** Ensures that the props do not include string ref, which cannot be forwarded */
/* Rewritten from type alias, can be one of: 
  - P
  - typingsSlinky.react.mod.PropsWithoutRef[P] with typingsSlinky.react.anon.`0`
*/
trait PropsWithRef[P] extends js.Object

object PropsWithRef {
  @scala.inline
  implicit def apply[P](value: PropsWithoutRef[P] with `0`): PropsWithRef[P] = value.asInstanceOf[PropsWithRef[P]]
  @scala.inline
  implicit def apply[P](value: P): PropsWithRef[P] = value.asInstanceOf[PropsWithRef[P]]
}

