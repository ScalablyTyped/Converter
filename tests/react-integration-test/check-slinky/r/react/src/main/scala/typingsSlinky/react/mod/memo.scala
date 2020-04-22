package typingsSlinky.react.mod

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "memo")
@js.native
object memo extends js.Object {
  def apply[T /* <: ReactComponentClass[_] */](Component: T): ReactComponentClass[T] = js.native
  def apply[T /* <: ReactComponentClass[_] */](
    Component: T,
    propsAreEqual: js.Function2[/* prevProps */ ComponentProps[T], /* nextProps */ ComponentProps[T], Boolean]
  ): ReactComponentClass[T] = js.native
  def apply[P /* <: js.Object */](Component: ReactComponentClass[P]): ReactComponentClass[P] = js.native
  def apply[P /* <: js.Object */](
    Component: ReactComponentClass[P],
    propsAreEqual: js.Function2[/* prevProps */ PropsWithChildren[P], /* nextProps */ PropsWithChildren[P], Boolean]
  ): ReactComponentClass[P] = js.native
}

