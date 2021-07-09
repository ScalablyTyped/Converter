package typingsSlinky.semanticUiReact

import org.scalablytyped.runtime.Shortcut
import slinky.core.ReactComponentClass
import typingsSlinky.semanticUiReact.testContainerTestContainerMod.TestContainerProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object testContainerMod extends Shortcut {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/TestContainer", JSImport.Default)
  @js.native
  val default: ReactComponentClass[TestContainerProps] = js.native
  
  type _To = ReactComponentClass[TestContainerProps]
  
  /* This means you don't have to write `default`, but can instead just say `testContainerMod.foo` */
  override def _to: ReactComponentClass[TestContainerProps] = default
}
