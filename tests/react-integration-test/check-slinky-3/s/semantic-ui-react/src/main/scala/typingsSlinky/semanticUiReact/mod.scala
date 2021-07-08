package typingsSlinky.semanticUiReact

import slinky.core.ReactComponentClass
import typingsSlinky.semanticUiReact.buttonContentMod.ButtonContentProps
import typingsSlinky.semanticUiReact.buttonGroupMod.ButtonGroupProps
import typingsSlinky.semanticUiReact.buttonOrMod.ButtonOrProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
  @js.native
  class default ()
    extends typingsSlinky.semanticUiReact.buttonMod.default
  object default {
    
    /* was `typeof ButtonContent` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Content")
    @js.native
    val Content: ReactComponentClass[ButtonContentProps] = js.native
    
    /* was `typeof ButtonGroup` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Group")
    @js.native
    val Group: ReactComponentClass[ButtonGroupProps] = js.native
    
    /* was `typeof ButtonOr` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Or")
    @js.native
    val Or: ReactComponentClass[ButtonOrProps] = js.native
  }
}
