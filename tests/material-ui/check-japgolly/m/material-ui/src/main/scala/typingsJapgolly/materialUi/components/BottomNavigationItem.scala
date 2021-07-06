package typingsJapgolly.materialUi.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object BottomNavigationItem {
  
  @scala.inline
  def apply(children: Double): Builder = {
    val __props = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[BottomNavigationItemProps]))
  }
  
  @JSImport("material-ui/BottomNavigation/BottomNavigationItem", "BottomNavigationItem")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[typingsJapgolly.materialUi.bottomNavigationItemMod.BottomNavigationItem] {
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: BottomNavigationItemProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
