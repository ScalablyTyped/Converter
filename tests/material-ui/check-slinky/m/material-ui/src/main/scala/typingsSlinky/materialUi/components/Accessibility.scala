package typingsSlinky.materialUi.components

import typingsSlinky.materialUi.accessibilityMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Accessibility {
  @JSImport("material-ui/svg-icons/action/accessibility", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: js.Object): SharedBuilder_Object_159303587[default] = new SharedBuilder_Object_159303587[default](js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: Accessibility.type): SharedBuilder_Object_159303587[default] = new SharedBuilder_Object_159303587[default](js.Array(this.component, js.Dictionary.empty))()
}

