package typingsSlinky.materialUi.components

import typingsSlinky.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object MaterialUIBottomNavigationBottomNavigationItem {
  @JSGlobal("__MaterialUI.BottomNavigation.BottomNavigationItem")
  @js.native
  object component extends js.Object
  
  def withProps(p: BottomNavigationItemProps): SharedBuilder_BottomNavigationItemProps_1638895878[typingsSlinky.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem] = new SharedBuilder_BottomNavigationItemProps_1638895878[typingsSlinky.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem](js.Array(this.component, p.asInstanceOf[js.Any]))
  @scala.inline
  def apply(children: Double): SharedBuilder_BottomNavigationItemProps_1638895878[typingsSlinky.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem] = {
    val __props = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
    new SharedBuilder_BottomNavigationItemProps_1638895878[typingsSlinky.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem](js.Array(this.component, __props.asInstanceOf[BottomNavigationItemProps]))
  }
}

