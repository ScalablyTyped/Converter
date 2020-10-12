package typingsSlinky.semanticUiReact

import slinky.core.ReactComponentClass
import typingsSlinky.semanticUiReact.buttonContentMod.ButtonContentProps
import typingsSlinky.semanticUiReact.buttonGroupMod.ButtonGroupProps
import typingsSlinky.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
  @js.native
  class default ()
    extends typingsSlinky.semanticUiReact.buttonMod.default
  /* static members */
  object default {
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Content")
    @js.native
    def Content: ReactComponentClass[ButtonContentProps] = js.native
    @scala.inline
    def Content_=(x: ReactComponentClass[ButtonContentProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Content")(x.asInstanceOf[js.Any])
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Group")
    @js.native
    def Group: ReactComponentClass[ButtonGroupProps] = js.native
    @scala.inline
    def Group_=(x: ReactComponentClass[ButtonGroupProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Group")(x.asInstanceOf[js.Any])
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Or")
    @js.native
    def Or: ReactComponentClass[ButtonOrProps] = js.native
    @scala.inline
    def Or_=(x: ReactComponentClass[ButtonOrProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Or")(x.asInstanceOf[js.Any])
  }
}
