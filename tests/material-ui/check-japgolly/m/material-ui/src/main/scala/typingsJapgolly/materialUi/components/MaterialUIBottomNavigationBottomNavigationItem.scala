package typingsJapgolly.materialUi.components

import typingsJapgolly.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object MaterialUIBottomNavigationBottomNavigationItem {
  @JSGlobal("__MaterialUI.BottomNavigation.BottomNavigationItem")
  @js.native
  object component extends js.Object
  
  def withProps(p: BottomNavigationItemProps): SharedBuilder_BottomNavigationItemProps226372499[
    typingsJapgolly.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem
  ] = new SharedBuilder_BottomNavigationItemProps226372499[
    typingsJapgolly.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem
  ](js.Array(this.component, p.asInstanceOf[js.Any]))
  @scala.inline
  def apply(children: Double): SharedBuilder_BottomNavigationItemProps226372499[
    typingsJapgolly.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem
  ] = {
    val __props = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
    new SharedBuilder_BottomNavigationItemProps226372499[
      typingsJapgolly.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem
    ](js.Array(this.component, __props.asInstanceOf[BottomNavigationItemProps]))
  }
}

