package mylib.internal.baz.materialUi.components

import mylib.internal.baz.StBuildingComponent
import mylib.internal.baz.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

private[internal] object BottomNavigationItem {
  
  inline def apply(children: Double): Builder = {
    val __props = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[BottomNavigationItemProps]))
  }
  
  @JSImport("material-ui/BottomNavigation/BottomNavigationItem", "BottomNavigationItem")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[mylib.internal.baz.materialUi.bottomNavigationItemMod.BottomNavigationItem] {
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: BottomNavigationItemProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
