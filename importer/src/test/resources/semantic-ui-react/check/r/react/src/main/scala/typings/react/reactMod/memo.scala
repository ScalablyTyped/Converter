package typings.react.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "memo")
@js.native
object memo extends js.Object {
  def apply[T /* <: ComponentType[_] */](Component: T): MemoExoticComponent[T] = js.native
  def apply[T /* <: ComponentType[_] */](
    Component: T,
    propsAreEqual: js.Function2[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<ComponentProps<T>> */ /* prevProps */ js.Any, 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<ComponentProps<T>> */ /* nextProps */ js.Any, 
      Boolean
    ]
  ): MemoExoticComponent[T] = js.native
  def apply[P /* <: js.Object */](Component: SFC[P]): NamedExoticComponent[P] = js.native
  def apply[P /* <: js.Object */](
    Component: SFC[P],
    propsAreEqual: js.Function2[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<PropsWithChildren<P>> */ /* prevProps */ js.Any, 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<PropsWithChildren<P>> */ /* nextProps */ js.Any, 
      Boolean
    ]
  ): NamedExoticComponent[P] = js.native
}

