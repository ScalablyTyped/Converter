package typingsJapgolly.semanticUiReact

import typingsJapgolly.react.mod.StatelessComponent
import typingsJapgolly.semanticUiReact.distCommonjsElementsButtonButtonContentMod.ButtonContentProps
import typingsJapgolly.semanticUiReact.distCommonjsElementsButtonButtonGroupMod.ButtonGroupProps
import typingsJapgolly.semanticUiReact.distCommonjsElementsButtonButtonOrMod.ButtonOrProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distCommonjsElementsButtonMod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
  @js.native
  open class default ()
    extends typingsJapgolly.semanticUiReact.distCommonjsElementsButtonButtonMod.default
  object default {
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    /* static member */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Content")
    @js.native
    def Content: StatelessComponent[ButtonContentProps] = js.native
    inline def Content_=(x: StatelessComponent[ButtonContentProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Content")(x.asInstanceOf[js.Any])
    
    /* static member */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Group")
    @js.native
    def Group: StatelessComponent[ButtonGroupProps] = js.native
    inline def Group_=(x: StatelessComponent[ButtonGroupProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Group")(x.asInstanceOf[js.Any])
    
    /* static member */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Or")
    @js.native
    def Or: StatelessComponent[ButtonOrProps] = js.native
    inline def Or_=(x: StatelessComponent[ButtonOrProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Or")(x.asInstanceOf[js.Any])
  }
}
