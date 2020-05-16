package typingsSlinky.stardustUiReactComponentRef.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  @JSImport("@stardust-ui/react-component-ref/dist/es/Ref", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  def apply(innerRef: typingsSlinky.react.mod.Ref[_] = null, _overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal(innerRef = innerRef.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = RefProps
}

