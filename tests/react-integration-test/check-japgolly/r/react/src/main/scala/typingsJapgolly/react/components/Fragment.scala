package typingsJapgolly.react.components

import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.react.anon.Children
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Fragment {
  @JSImport("react", "Fragment")
  @js.native
  object component extends js.Object
  
  def withProps(p: Children): Default[js.Object] = new Default[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: Fragment.type): Default[js.Object] = new Default[js.Object](js.Array(this.component, js.Dictionary.empty))()
}

