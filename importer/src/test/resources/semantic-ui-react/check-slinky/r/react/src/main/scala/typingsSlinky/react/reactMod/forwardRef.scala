package typingsSlinky.react.reactMod

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "forwardRef")
@js.native
object forwardRef extends js.Object {
  def apply[T, P](Component: ReactComponentClass[T]): ForwardRefExoticComponent[PropsWithoutRef[P] with RefAttributes[T]] = js.native
}

