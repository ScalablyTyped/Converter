package typingsJapgolly.react.mod

import typingsJapgolly.std.stdStrings.Partial
import typingsJapgolly.std.stdStrings.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - P
  - typingsJapgolly.react.mod.Defaultize[
(typingsJapgolly.react.mod.MergePropTypes[
  P, 
  / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> * / js.Any
]) | P, 
js.Any]
  - typingsJapgolly.react.mod.MergePropTypes[
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

