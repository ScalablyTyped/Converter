package typings.react.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "createContext")
@js.native
object createContext extends js.Object {
  def apply[T](defaultValue: T): Context[T] = js.native
  def apply[T](defaultValue: T, calculateChangedBits: js.Function2[/* prev */ T, /* next */ T, Double]): Context[T] = js.native
}

