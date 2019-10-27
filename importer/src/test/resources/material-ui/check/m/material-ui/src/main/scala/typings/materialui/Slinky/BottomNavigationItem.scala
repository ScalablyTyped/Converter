package typings.materialUi.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps
import typings.materialUi.bottomNavigationBottomNavigationItemMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object BottomNavigationItem
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.materialUi.bottomNavigationBottomNavigationItemMod.default].asInstanceOf[String | js.Object]
  def apply(className: String = null): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    if (className != null) __obj.updateDynamic("className")(className)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = BottomNavigationItemProps
}

