package typingsJapgolly.semanticUiReact

import org.scalablytyped.runtime.Shortcut
import typingsJapgolly.react.mod.StatelessComponent
import typingsJapgolly.semanticUiReact.distCommonjsElementsTestContainerTestContainerMod.TestContainerProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distCommonjsElementsTestContainerMod extends Shortcut {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/TestContainer", JSImport.Default)
  @js.native
  val default: StatelessComponent[TestContainerProps] = js.native
  
  type _To = StatelessComponent[TestContainerProps]
  
  /* This means you don't have to write `default`, but can instead just say `distCommonjsElementsTestContainerMod.foo` */
  override def _to: StatelessComponent[TestContainerProps] = default
}
