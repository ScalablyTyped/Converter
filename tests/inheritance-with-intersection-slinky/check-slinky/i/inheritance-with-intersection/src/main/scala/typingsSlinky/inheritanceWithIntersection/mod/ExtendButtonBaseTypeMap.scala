package typingsSlinky.inheritanceWithIntersection.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ExtendButtonBaseTypeMap[M /* <: OverridableTypeMap */] extends js.Object {
  var defaultComponent: js.Any = js.native
  var props: js.Any = js.native
}

object ExtendButtonBaseTypeMap {
  @scala.inline
  def apply[/* <: typingsSlinky.inheritanceWithIntersection.mod.OverridableTypeMap */ M](defaultComponent: js.Any, props: js.Any): ExtendButtonBaseTypeMap[M] = {
    val __obj = js.Dynamic.literal(defaultComponent = defaultComponent.asInstanceOf[js.Any], props = props.asInstanceOf[js.Any])
    __obj.asInstanceOf[ExtendButtonBaseTypeMap[M]]
  }
  @scala.inline
  implicit class ExtendButtonBaseTypeMapOps[Self <: ExtendButtonBaseTypeMap[_], /* <: typingsSlinky.inheritanceWithIntersection.mod.OverridableTypeMap */ M] (val x: Self with ExtendButtonBaseTypeMap[M]) extends AnyVal {
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
    def setDefaultComponent(value: js.Any): Self = this.set("defaultComponent", value.asInstanceOf[js.Any])
    @scala.inline
    def setProps(value: js.Any): Self = this.set("props", value.asInstanceOf[js.Any])
  }
  
}

