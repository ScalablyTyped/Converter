package typingsSlinky.stardustUiReactComponentRef.components

import typingsSlinky.stardustUiReactComponentRef.distEsTypesMod.RefProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object RefForward {
  
  @JSImport("@stardust-ui/react-component-ref", "RefForward")
  @js.native
  val component: js.Object = js.native
  
  type Props = RefProps
  
  implicit def make(companion: RefForward.type): SharedBuilder_RefProps_93134828[typingsSlinky.stardustUiReactComponentRef.mod.RefForward] = new SharedBuilder_RefProps_93134828[typingsSlinky.stardustUiReactComponentRef.mod.RefForward](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: RefProps): SharedBuilder_RefProps_93134828[typingsSlinky.stardustUiReactComponentRef.mod.RefForward] = new SharedBuilder_RefProps_93134828[typingsSlinky.stardustUiReactComponentRef.mod.RefForward](js.Array(this.component, p.asInstanceOf[js.Any]))
}
