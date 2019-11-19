package typingsJapgolly.reactTransitionGroup

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_Child extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ Element, Element]] = js.undefined
}

object Anon_Child {
  @scala.inline
  def apply(childFactory: js.UndefOr[/* child */ Element => CallbackTo[Element]] = js.undefined): Anon_Child = {
    val __obj = js.Dynamic.literal()
    childFactory.foreach(x => __obj.updateDynamic("childFactory")(js.Any.fromFunction1((t0: /* child */ japgolly.scalajs.react.raw.React.Element) => x(t0).runNow())))
    __obj.asInstanceOf[Anon_Child]
  }
}

