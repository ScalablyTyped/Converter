package typings.react.mod

import typings.react.anon.RefAny
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/** Ensures that the props do not include string ref, which cannot be forwarded */
/* Rewritten from type alias, can be one of: 
  - P
  - typings.react.mod.PropsWithoutRef[P] with typings.react.anon.RefAny
*/
trait PropsWithRef[P] extends js.Object

object PropsWithRef {
  @scala.inline
  implicit def apply[P](value: PropsWithoutRef[P] with RefAny): PropsWithRef[P] = value.asInstanceOf[PropsWithRef[P]]
  @scala.inline
  implicit def apply[P](value: P): PropsWithRef[P] = value.asInstanceOf[PropsWithRef[P]]
}

