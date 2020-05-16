package typingsJapgolly.semanticUiReact.testContainerTestContainerMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TestContainerProps
  extends StrictTestContainerProps
     with /* key */ StringDictionary[js.Any]

object TestContainerProps {
  @scala.inline
  def apply(
    requiredFn0Number: CallbackTo[Double],
    requiredFn0Void: Callback,
    requiredFn1Number: Double => CallbackTo[Double],
    requiredFn1Void: Double => Callback
  ): TestContainerProps = {
    val __obj = js.Dynamic.literal(requiredFn0Number = requiredFn0Number.toJsFn, requiredFn0Void = requiredFn0Void.toJsFn, requiredFn1Number = js.Any.fromFunction1((t0: Double) => requiredFn1Number(t0).runNow()), requiredFn1Void = js.Any.fromFunction1((t0: Double) => requiredFn1Void(t0).runNow()))
    __obj.asInstanceOf[TestContainerProps]
  }
}

