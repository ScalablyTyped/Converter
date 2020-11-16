package typingsJapgolly.stardustUiReactComponentRef.components

import typingsJapgolly.stardustUiReactComponentRef.refFindNodeMod.default
import typingsJapgolly.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object RefFindNode {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/RefFindNode", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: RefProps): SharedBuilder_RefProps171925374[default] = new SharedBuilder_RefProps171925374[default](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: RefFindNode.type): SharedBuilder_RefProps171925374[default] = new SharedBuilder_RefProps171925374[default](js.Array(this.component, js.Dictionary.empty))()
}
