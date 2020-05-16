package typingsJapgolly.reactTransitionGroup

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonChildFactory extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ Element, Element]] = js.native
}

object AnonChildFactory {
  @scala.inline
  def apply(childFactory: /* child */ Element => CallbackTo[Element] = null): AnonChildFactory = {
    val __obj = js.Dynamic.literal()
    if (childFactory != null) __obj.updateDynamic("childFactory")(js.Any.fromFunction1((t0: /* child */ Element) => childFactory(t0).runNow()))
    __obj.asInstanceOf[AnonChildFactory]
  }
  @scala.inline
  implicit class AnonChildFactoryOps[Self <: AnonChildFactory] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildFactory(childFactory: /* child */ Element => CallbackTo[Element]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (childFactory != null) ret.updateDynamic("childFactory")(js.Any.fromFunction1((t0: /* child */ Element) => childFactory(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutChildFactory: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "childFactory")
        ret.asInstanceOf[Self]
    }
  }
  
}

