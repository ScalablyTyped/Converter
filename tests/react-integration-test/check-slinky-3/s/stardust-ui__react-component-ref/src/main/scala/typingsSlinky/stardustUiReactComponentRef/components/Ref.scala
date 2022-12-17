package typingsSlinky.stardustUiReactComponentRef.components

import typingsSlinky.stardustUiReactComponentRef.distEsTypesMod.RefProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Ref {
  
  @JSImport("@stardust-ui/react-component-ref", "Ref")
  @js.native
  val component: js.Object = js.native
  
  type Props = RefProps
  
  implicit def make(companion: Ref.type): SharedBuilder_RefProps_93134828[js.Object] = new SharedBuilder_RefProps_93134828[js.Object](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: RefProps): SharedBuilder_RefProps_93134828[js.Object] = new SharedBuilder_RefProps_93134828[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
}
