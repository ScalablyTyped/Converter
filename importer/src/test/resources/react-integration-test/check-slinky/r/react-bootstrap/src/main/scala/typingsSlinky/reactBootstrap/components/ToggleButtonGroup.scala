package typingsSlinky.reactBootstrap.components

import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactBootstrap.toggleButtonGroupMod.ToggleButtonGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. QualifiedName(IArray(Name(typingsSlinky), Name(reactBootstrap), Name(toggleButtonGroupMod), Name(ToggleButtonGroupProps))) was not a @ScalaJSDefined trait */
object ToggleButtonGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactBootstrap.mod.ToggleButtonGroup] {
  @JSImport("react-bootstrap", "ToggleButtonGroup")
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  type Props = ToggleButtonGroupProps
}

