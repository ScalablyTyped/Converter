package typingsSlinky.materialUi.components

import slinky.core.ExternalComponentNoPropsWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.materialUi.accessibilityMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Accessibility
  extends ExternalComponentNoPropsWithAttributesWithRefType[tag.type, default] {
  @JSImport("material-ui/svg-icons/action/accessibility", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
}

