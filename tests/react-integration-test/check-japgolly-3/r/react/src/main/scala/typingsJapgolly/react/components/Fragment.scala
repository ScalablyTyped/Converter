package typingsJapgolly.react.components

import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.react.anon.Children
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Fragment {
  
  @JSImport("react", "Fragment")
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: Fragment.type): Default[js.Object] = new Default[js.Object](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: Children): Default[js.Object] = new Default[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
}
