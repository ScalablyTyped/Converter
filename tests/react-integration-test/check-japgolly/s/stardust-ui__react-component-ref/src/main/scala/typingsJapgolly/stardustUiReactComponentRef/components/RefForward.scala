package typingsJapgolly.stardustUiReactComponentRef.components

import typingsJapgolly.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object RefForward {
  @JSImport("@stardust-ui/react-component-ref", "RefForward")
  @js.native
  object component extends js.Object
  
  def withProps(p: RefProps): SharedBuilder_RefProps171925374[typingsJapgolly.stardustUiReactComponentRef.mod.RefForward] = new SharedBuilder_RefProps171925374[typingsJapgolly.stardustUiReactComponentRef.mod.RefForward](js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: RefForward.type): SharedBuilder_RefProps171925374[typingsJapgolly.stardustUiReactComponentRef.mod.RefForward] = new SharedBuilder_RefProps171925374[typingsJapgolly.stardustUiReactComponentRef.mod.RefForward](js.Array(this.component, js.Dictionary.empty))()
}

