package typingsSlinky.semanticUiReact

import slinky.core.ReactComponentClass
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonContentMod.ButtonContentProps
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonGroupMod.ButtonGroupProps
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonOrMod.ButtonOrProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distCommonjsElementsButtonMod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
  @js.native
  open class default ()
    extends typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonMod.default
  object default {
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    /* static member */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Content")
    @js.native
    def Content: ReactComponentClass[ButtonContentProps] = js.native
    inline def Content_=(x: ReactComponentClass[ButtonContentProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Content")(x.asInstanceOf[js.Any])
    
    /* static member */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Group")
    @js.native
    def Group: ReactComponentClass[ButtonGroupProps] = js.native
    inline def Group_=(x: ReactComponentClass[ButtonGroupProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Group")(x.asInstanceOf[js.Any])
    
    /* static member */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Or")
    @js.native
    def Or: ReactComponentClass[ButtonOrProps] = js.native
    inline def Or_=(x: ReactComponentClass[ButtonOrProps]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Or")(x.asInstanceOf[js.Any])
  }
}
