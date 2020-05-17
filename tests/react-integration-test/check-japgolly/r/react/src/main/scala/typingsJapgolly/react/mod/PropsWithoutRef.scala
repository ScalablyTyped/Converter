package typingsJapgolly.react.mod

import typingsJapgolly.std.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/** Ensures that the props do not include ref at all */
/* Rewritten from type alias, can be one of: 
  - P
  - typingsJapgolly.std.Pick[
P, 
/ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, 'ref'> * / js.Any]
*/
trait PropsWithoutRef[P] extends js.Object

object PropsWithoutRef {
  @scala.inline
  implicit def apply[P](value: P): PropsWithoutRef[P] = value.asInstanceOf[PropsWithoutRef[P]]
  @scala.inline
  implicit def apply[P](
    value: Pick[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, 'ref'> */ js.Any
    ]
  ): PropsWithoutRef[P] = value.asInstanceOf[PropsWithoutRef[P]]
}

