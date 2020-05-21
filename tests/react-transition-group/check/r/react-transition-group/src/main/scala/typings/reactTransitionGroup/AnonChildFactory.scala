package typings.reactTransitionGroup

import typings.react.mod.ReactElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonChildFactory extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ ReactElement, ReactElement]] = js.native
}

object AnonChildFactory {
  @scala.inline
  def apply(): AnonChildFactory = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[AnonChildFactory]
  }
  @scala.inline
  implicit class AnonChildFactoryOps[Self <: AnonChildFactory] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildFactory(value: /* child */ ReactElement => ReactElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("childFactory")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withoutChildFactory: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("childFactory")(js.undefined)
        ret
    }
  }
  
}

