package typingsJapgolly.react.components

import _root_.typingsJapgolly.StBuildingComponent.Default
import _root_.typingsJapgolly.react.anon.Children
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object StrictMode {
  
  @JSImport("react", "StrictMode")
  @js.native
  val component: js.Object = js.native
  
  type Props = Children
  
  implicit def make(companion: StrictMode.type): Default[js.Object] = new Default[js.Object](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: Children): Default[js.Object] = new Default[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
}
