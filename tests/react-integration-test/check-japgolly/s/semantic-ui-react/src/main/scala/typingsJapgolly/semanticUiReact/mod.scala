package typingsJapgolly.semanticUiReact

import typingsJapgolly.react.mod.StatelessComponent
import typingsJapgolly.semanticUiReact.buttonContentMod.ButtonContentProps
import typingsJapgolly.semanticUiReact.buttonGroupMod.ButtonGroupProps
import typingsJapgolly.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
  @js.native
  class default ()
    extends typingsJapgolly.semanticUiReact.buttonMod.default
  /* static members */
  object default {
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Content")
    @js.native
    def Content: StatelessComponent[ButtonContentProps] = js.native
    @scala.inline
    def Content_=(x: StatelessComponent[ButtonContentProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Content")(x.asInstanceOf[js.Any])
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Group")
    @js.native
    def Group: StatelessComponent[ButtonGroupProps] = js.native
    @scala.inline
    def Group_=(x: StatelessComponent[ButtonGroupProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Group")(x.asInstanceOf[js.Any])
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Or")
    @js.native
    def Or: StatelessComponent[ButtonOrProps] = js.native
    @scala.inline
    def Or_=(x: StatelessComponent[ButtonOrProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Or")(x.asInstanceOf[js.Any])
  }
}
