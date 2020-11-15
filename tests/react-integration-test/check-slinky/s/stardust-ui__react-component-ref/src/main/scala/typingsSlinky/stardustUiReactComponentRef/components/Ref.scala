package typingsSlinky.stardustUiReactComponentRef.components

import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Ref {
  
  @JSImport("@stardust-ui/react-component-ref", "Ref")
  @js.native
  object component extends js.Object
  
  def withProps(p: RefProps): SharedBuilder_RefProps1237054395[js.Object] = new SharedBuilder_RefProps1237054395[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: Ref.type): SharedBuilder_RefProps1237054395[js.Object] = new SharedBuilder_RefProps1237054395[js.Object](js.Array(this.component, js.Dictionary.empty))()
}
