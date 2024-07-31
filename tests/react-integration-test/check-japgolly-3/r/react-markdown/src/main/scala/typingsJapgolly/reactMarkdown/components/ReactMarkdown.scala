package typingsJapgolly.reactMarkdown.components

import _root_.typingsJapgolly.StBuildingComponent.Default
import _root_.typingsJapgolly.reactMarkdown.mod.ReactMarkdownProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . Support for combinations of intersection and union types not implemented */
object ReactMarkdown {
  
  def apply(p: ReactMarkdownProps): Default[js.Object] = new Default[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  @JSImport("react-markdown", JSImport.Namespace)
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: ReactMarkdown.type): Default[js.Object] = new Default[js.Object](js.Array(this.component, js.Dictionary.empty))()
}
