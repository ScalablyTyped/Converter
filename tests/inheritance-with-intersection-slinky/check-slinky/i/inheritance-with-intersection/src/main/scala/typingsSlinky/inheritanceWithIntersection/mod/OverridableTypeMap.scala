package typingsSlinky.inheritanceWithIntersection.mod

import slinky.core.facade.ReactElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait OverridableTypeMap extends js.Object {
  var defaultComponent: ReactElement = js.native
}

object OverridableTypeMap {
  @scala.inline
  def apply(defaultComponent: ReactElement): OverridableTypeMap = {
    val __obj = js.Dynamic.literal(defaultComponent = defaultComponent.asInstanceOf[js.Any])
    __obj.asInstanceOf[OverridableTypeMap]
  }
  @scala.inline
  implicit class OverridableTypeMapOps[Self <: OverridableTypeMap] (val x: Self) extends AnyVal {
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
    def setDefaultComponent(value: ReactElement): Self = this.set("defaultComponent", value.asInstanceOf[js.Any])
  }
  
}

