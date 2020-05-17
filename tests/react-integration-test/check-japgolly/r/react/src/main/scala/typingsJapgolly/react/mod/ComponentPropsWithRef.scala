package typingsJapgolly.react.mod

import typingsJapgolly.react.anon.`0`
import typingsJapgolly.std.stdStrings.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.react.mod.PropsWithRef[typingsJapgolly.react.mod.ComponentProps[T]]
  - typingsJapgolly.react.mod.PropsWithoutRef[_] with (typingsJapgolly.react.mod.RefAttributes[
/ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> * / _])
*/
trait ComponentPropsWithRef[T /* <: japgolly.scalajs.react.raw.React.ElementType */] extends js.Object

object ComponentPropsWithRef {
  @scala.inline
  implicit def apply[/* <: typingsJapgolly.react.mod.ElementType[_] */ T](
    value: ((/* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ Pick with ComponentProps[T]) | js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)) with `0`
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[/* <: typingsJapgolly.react.mod.ElementType[_] */ T](
    value: PropsWithoutRef[_] with (RefAttributes[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ _
    ])
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[/* <: typingsJapgolly.react.mod.ElementType[_] */ T](
    value: /* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[/* <: typingsJapgolly.react.mod.ElementType[_] */ T](value: js.Object): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
}

