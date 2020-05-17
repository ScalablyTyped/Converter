package typingsSlinky.react.mod

import typingsSlinky.std.Partial
import typingsSlinky.std.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// Any prop that has a default prop becomes optional, but its type is unchanged
// Undeclared default props are augmented into the resulting allowable attributes
// If declared props have indexed properties, ignore default props entirely as keyof gets widened
// Wrap in an outer-level conditional type to allow distribution over props that are unions
/* Rewritten from type alias, can be one of: 
  - (typingsSlinky.std.Pick[
P, 
/ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof D> * / _]) with (typingsSlinky.std.Partial[
typingsSlinky.std.Pick[
  P, 
  / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> * / _
]]) with (typingsSlinky.std.Partial[
typingsSlinky.std.Pick[
  D, 
  / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof D, keyof P> * / _
]])
  - P
*/
trait Defaultize[P, D] extends js.Object

object Defaultize {
  @scala.inline
  implicit def apply[P, D](
    value: (Pick[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof D> */ _
    ]) with (Partial[
      Pick[
        P, 
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> */ _
      ]
    ]) with (Partial[
      Pick[
        D, 
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof D, keyof P> */ _
      ]
    ])
  ): Defaultize[P, D] = value.asInstanceOf[Defaultize[P, D]]
  @scala.inline
  implicit def apply[P, D](value: P): Defaultize[P, D] = value.asInstanceOf[Defaultize[P, D]]
}

