package typingsJapgolly.stardustUiReactComponentRef.components

import typingsJapgolly.stardustUiReactComponentRef.distEsRefForwardMod.default
import typingsJapgolly.stardustUiReactComponentRef.distEsTypesMod.RefProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object RefForward {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = RefProps
  
  implicit def make(companion: RefForward.type): SharedBuilder_RefProps_154979285[default] = new SharedBuilder_RefProps_154979285[default](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: RefProps): SharedBuilder_RefProps_154979285[default] = new SharedBuilder_RefProps_154979285[default](js.Array(this.component, p.asInstanceOf[js.Any]))
}
