package typingsSlinky.atStardustDashUiReactDashComponentDashRef.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref {
  object raw
    extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
    @JSImport("@stardust-ui/react-component-ref/dist/es/Ref", JSImport.Default)
    @js.native
    object componentImport extends js.Object
    
    override val component: String | js.Object = this.componentImport
    type Props = RefProps
  }
  
  def apply(innerRef: typingsSlinky.react.reactMod.Ref[_] = null, _overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal()
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

