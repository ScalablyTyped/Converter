package typingsSlinky.materialDashUi.__MaterialUI.BottomNavigation

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait BottomNavigationItemProps extends js.Object {
  var children: Double
  var className: js.UndefOr[String] = js.undefined
}

object BottomNavigationItemProps {
  @scala.inline
  def apply(children: Double, className: String = null): BottomNavigationItemProps = {
    val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    __obj.asInstanceOf[BottomNavigationItemProps]
  }
}

