package typingsSlinky.react.mod

import typingsSlinky.react.anon.`0`
import typingsSlinky.std.stdStrings.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsSlinky.react.mod.PropsWithRef[typingsSlinky.react.mod.ComponentProps[T]]
  - typingsSlinky.react.mod.PropsWithoutRef[_] with (typingsSlinky.react.mod.RefAttributes[
/ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> * / _])
*/
trait ComponentPropsWithRef[T /* <: slinky.core.facade.ReactElement */] extends js.Object

object ComponentPropsWithRef {
  @scala.inline
  implicit def apply[/* <: typingsSlinky.react.mod.ElementType[_] */ T](
    value: PropsWithoutRef[_] with (RefAttributes[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ _
    ])
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[/* <: typingsSlinky.react.mod.ElementType[_] */ T](
    value: ((/* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ Pick with ComponentProps[T]) | js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)) with `0`
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[/* <: typingsSlinky.react.mod.ElementType[_] */ T](
    value: /* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any
  ): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
  @scala.inline
  implicit def apply[/* <: typingsSlinky.react.mod.ElementType[_] */ T](value: js.Object): ComponentPropsWithRef[T] = value.asInstanceOf[ComponentPropsWithRef[T]]
}

