package typingsSlinky.react.mod

import typingsSlinky.std.stdStrings.Partial
import typingsSlinky.std.stdStrings.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - P
  - typingsSlinky.react.mod.Defaultize[
(typingsSlinky.react.mod.MergePropTypes[
  P, 
  / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> * / js.Any
]) | P, 
js.Any]
  - typingsSlinky.react.mod.MergePropTypes[
P, 
/ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> * / js.Any]
*/
trait ReactManagedAttributes[C, P] extends js.Object

object ReactManagedAttributes {
  @scala.inline
  implicit def apply[C, P](
    value: Pick with ((MergePropTypes[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
    ]) | P) with Partial with js.Any with P
  ): ReactManagedAttributes[C, P] = value.asInstanceOf[ReactManagedAttributes[C, P]]
  @scala.inline
  implicit def apply[C, P](
    value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
  ): ReactManagedAttributes[C, P] = value.asInstanceOf[ReactManagedAttributes[C, P]]
  @scala.inline
  implicit def apply[C, P](value: P): ReactManagedAttributes[C, P] = value.asInstanceOf[ReactManagedAttributes[C, P]]
}

