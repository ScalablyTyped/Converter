package typingsJapgolly.reactMarkdown.components

import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.reactMarkdown.mod.ReactMarkdownProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . Couldn't find props for typingsJapgolly.reactMarkdown.mod.ReactMarkdownProps because: IArray(Couldn't find props for typingsJapgolly.reactMarkdown.mod.ChildrenProp & typingsJapgolly.reactMarkdown.reactMarkdownStrings.Not & js.Any because: IArray(Could't extract props from js.Any because couldn't resolve ClassTree.), Couldn't find props for typingsJapgolly.reactMarkdown.mod.SourceProp & typingsJapgolly.reactMarkdown.reactMarkdownStrings.Not & js.Any because: IArray(Could't extract props from js.Any because couldn't resolve ClassTree.)) */
object ReactMarkdown {
  
  def apply(p: ReactMarkdownProps): Default[js.Object] = new Default[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  @JSImport("react-markdown", JSImport.Namespace)
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: ReactMarkdown.type): Default[js.Object] = new Default[js.Object](js.Array(this.component, js.Dictionary.empty))()
}
