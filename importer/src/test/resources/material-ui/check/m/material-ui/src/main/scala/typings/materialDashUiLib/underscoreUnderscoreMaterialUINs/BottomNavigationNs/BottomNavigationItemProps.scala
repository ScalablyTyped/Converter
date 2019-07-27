package typings.materialDashUiLib.underscoreUnderscoreMaterialUINs.BottomNavigationNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait BottomNavigationItemProps extends js.Object {
  var className: js.UndefOr[String] = js.undefined
}

object BottomNavigationItemProps {
  @scala.inline
  def apply(className: String = null): BottomNavigationItemProps = {
    val __obj = js.Dynamic.literal()
    if (className != null) __obj.updateDynamic("className")(className)
    __obj.asInstanceOf[BottomNavigationItemProps]
  }
}

