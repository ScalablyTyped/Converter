package typingsSlinky.inheritanceWithIntersection.mod

import slinky.core.facade.ReactElement
import typingsSlinky.inheritanceWithIntersection.anon.CenterRipple
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ButtonBaseTypeMap[P, D /* <: ReactElement */] extends js.Object {
  var defaultComponent: D = js.native
  var props: P with CenterRipple = js.native
}

object ButtonBaseTypeMap {
  @scala.inline
  def apply[P, /* <: typingsSlinky.react.mod.ElementType */ D](defaultComponent: D, props: P with CenterRipple): ButtonBaseTypeMap[P, D] = {
    val __obj = js.Dynamic.literal(defaultComponent = defaultComponent.asInstanceOf[js.Any], props = props.asInstanceOf[js.Any])
    __obj.asInstanceOf[ButtonBaseTypeMap[P, D]]
  }
  @scala.inline
  implicit class ButtonBaseTypeMapOps[Self <: ButtonBaseTypeMap[_, _], P, /* <: typingsSlinky.react.mod.ElementType */ D] (val x: Self with (ButtonBaseTypeMap[P, D])) extends AnyVal {
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
    def setDefaultComponent(value: D): Self = this.set("defaultComponent", value.asInstanceOf[js.Any])
    @scala.inline
    def setProps(value: P with CenterRipple): Self = this.set("props", value.asInstanceOf[js.Any])
  }
  
}

