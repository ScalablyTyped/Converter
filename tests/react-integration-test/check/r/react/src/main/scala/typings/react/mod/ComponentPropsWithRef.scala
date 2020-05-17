package typings.react.mod

import typings.react.anon.RefAny
import typings.std.stdStrings.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.react.mod.PropsWithRef[typings.react.mod.ComponentProps[T]]
  - typings.react.mod.PropsWithoutRef[_] with (typings.react.mod.RefAttributes[
/ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> * / _])
*/
trait ComponentPropsWithRef[T /* <: ElementType[_] */] extends js.Object

object ComponentPropsWithRef {
  @scala.inline
  implicit def apply[T](
    value: ((/* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ Pick with ComponentProps[T]) | js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)) with RefAny
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[T](
    value: PropsWithoutRef[_] with (RefAttributes[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ _
    ])
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[T](
    value: /* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[T](value: js.Object): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
}

