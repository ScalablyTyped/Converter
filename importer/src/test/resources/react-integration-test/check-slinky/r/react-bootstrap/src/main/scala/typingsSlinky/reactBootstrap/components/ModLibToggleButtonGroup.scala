package typingsSlinky.reactBootstrap.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactBootstrap.mod.lib.ToggleButtonGroup.ToggleButtonGroupProps
import typingsSlinky.reactBootstrap.mod.lib.ToggleButtonGroup.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. QualifiedName(List(Name(typingsSlinky), Name(reactBootstrap), Name(mod), Name(lib), Name(ToggleButtonGroup), Name(ToggleButtonGroupProps))) was not a @ScalaJSDefined trait */
object ModLibToggleButtonGroup {
  object raw
    extends ExternalComponentWithAttributesWithRefType[tag.type, ^] {
    @JSImport("react-bootstrap/lib/ToggleButtonGroup", JSImport.Namespace)
    @js.native
    object componentImport extends js.Object
    
    override val component: String | js.Object = this.componentImport
    type Props = ToggleButtonGroupProps
  }
  
  def apply(props: ToggleButtonGroupProps with js.Object, _overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, ^] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, props)
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

