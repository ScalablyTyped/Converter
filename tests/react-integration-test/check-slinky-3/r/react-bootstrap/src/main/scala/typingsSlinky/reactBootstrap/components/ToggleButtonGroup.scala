package typingsSlinky.reactBootstrap.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent.Default
import typingsSlinky.reactBootstrap.toggleButtonGroupMod.ToggleButtonGroupProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . Couldn't find props for typingsSlinky.reactBootstrap.toggleButtonGroupMod.ToggleButtonGroupProps because: IArray(Could't extract props from "Pick" because couldn't resolve ClassTree.) */
object ToggleButtonGroup {
  
  def apply(p: ToggleButtonGroupProps): Default[tag.type, typingsSlinky.reactBootstrap.mod.ToggleButtonGroup] = new Default[tag.type, typingsSlinky.reactBootstrap.mod.ToggleButtonGroup](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  @JSImport("react-bootstrap", "ToggleButtonGroup")
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: ToggleButtonGroup.type): Default[tag.type, typingsSlinky.reactBootstrap.mod.ToggleButtonGroup] = new Default[tag.type, typingsSlinky.reactBootstrap.mod.ToggleButtonGroup](js.Array(this.component, js.Dictionary.empty))()
}
