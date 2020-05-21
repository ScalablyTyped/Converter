package typings.reactTransitionGroup.anon

import typings.react.mod.ReactElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ChildFactory extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ ReactElement, ReactElement]] = js.native
}

object ChildFactory {
  @scala.inline
  def apply(): ChildFactory = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ChildFactory]
  }
  @scala.inline
  implicit class ChildFactoryOps[Self <: ChildFactory] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setChildFactory(value: /* child */ ReactElement => ReactElement): Self = this.set("childFactory", js.Any.fromFunction1(value))
    @scala.inline
    def deleteChildFactory: Self = this.set("childFactory", js.undefined)
  }
  
}

