package typingsSlinky.stardustUiReactComponentRef.components

import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object RefForward {
  
  @JSImport("@stardust-ui/react-component-ref", "RefForward")
  @js.native
  val component: js.Object = js.native
  
  def withProps(p: RefProps): SharedBuilder_RefProps1237054395[typingsSlinky.stardustUiReactComponentRef.mod.RefForward] = new SharedBuilder_RefProps1237054395[typingsSlinky.stardustUiReactComponentRef.mod.RefForward](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: RefForward.type): SharedBuilder_RefProps1237054395[typingsSlinky.stardustUiReactComponentRef.mod.RefForward] = new SharedBuilder_RefProps1237054395[typingsSlinky.stardustUiReactComponentRef.mod.RefForward](js.Array(this.component, js.Dictionary.empty))()
}
