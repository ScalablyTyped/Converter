package typingsJapgolly.semanticUiReact

import typingsJapgolly.react.mod.StatelessComponent
import typingsJapgolly.semanticUiReact.buttonContentMod.ButtonContentProps
import typingsJapgolly.semanticUiReact.buttonGroupMod.ButtonGroupProps
import typingsJapgolly.semanticUiReact.buttonOrMod.ButtonOrProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
  @js.native
  class default ()
    extends typingsJapgolly.semanticUiReact.buttonMod.default
  object default {
    
    /* was `typeof ButtonContent` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Content")
    @js.native
    val Content: StatelessComponent[ButtonContentProps] = js.native
    
    /* was `typeof ButtonGroup` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Group")
    @js.native
    val Group: StatelessComponent[ButtonGroupProps] = js.native
    
    /* was `typeof ButtonOr` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Or")
    @js.native
    val Or: StatelessComponent[ButtonOrProps] = js.native
  }
}
