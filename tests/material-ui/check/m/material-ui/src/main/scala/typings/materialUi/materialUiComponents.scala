package typings.materialUi

import typings.materialUi.accessibilityMod.default
import typings.materialUi.global.MaterialUI.BottomNavigation.BottomNavigationItem
import typings.react.mod.ComponentType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object materialUiComponents extends materialUiProps {
  @scala.inline
  def Accessibility: ComponentType[js.Object] = js.constructorOf[default].asInstanceOf[ComponentType[js.Object]]
  @scala.inline
  def ActionAccessibility: ComponentType[js.Object] = js.constructorOf[typings.materialUi.accessibilityMod.ActionAccessibility].asInstanceOf[ComponentType[js.Object]]
  @scala.inline
  def BottomNavigationItem: ComponentType[BottomNavigationItemProps] = js.constructorOf[typings.materialUi.bottomNavigationItemMod.default].asInstanceOf[ComponentType[BottomNavigationItemProps]]
  @scala.inline
  def MaterialUIBottomNavigationBottomNavigationItem: ComponentType[MaterialUIBottomNavigationBottomNavigationItemProps] = js.constructorOf[BottomNavigationItem].asInstanceOf[ComponentType[MaterialUIBottomNavigationBottomNavigationItemProps]]
  @scala.inline
  def SvgIcon: ComponentType[js.Object] = js.constructorOf[typings.materialUi.global.MaterialUI.SvgIcon].asInstanceOf[ComponentType[js.Object]]
}

