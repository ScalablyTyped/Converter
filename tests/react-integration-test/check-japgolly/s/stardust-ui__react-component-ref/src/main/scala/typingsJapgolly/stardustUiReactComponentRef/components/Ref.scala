package typingsJapgolly.stardustUiReactComponentRef.components

import typingsJapgolly.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref {
  @JSImport("@stardust-ui/react-component-ref/dist/es/Ref", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: RefProps): SharedBuilder_RefProps171925374[js.Object] = new SharedBuilder_RefProps171925374[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: Ref.type): SharedBuilder_RefProps171925374[js.Object] = new SharedBuilder_RefProps171925374[js.Object](js.Array(this.component, js.Dictionary.empty))()
}

