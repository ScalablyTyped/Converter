package typingsSlinky.semanticUiReact

import slinky.core.ReactComponentClass
import typingsSlinky.semanticUiReact.buttonContentMod.ButtonContentProps
import typingsSlinky.semanticUiReact.buttonGroupMod.ButtonGroupProps
import typingsSlinky.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Namespace)
@js.native
object mod extends js.Object {
  /* static members */
  @js.native
  object default extends js.Object {
    var Content: ReactComponentClass[ButtonContentProps] = js.native
    var Group: ReactComponentClass[ButtonGroupProps] = js.native
    var Or: ReactComponentClass[ButtonOrProps] = js.native
  }
  
  @js.native
  class default ()
    extends typingsSlinky.semanticUiReact.buttonMod.default
  
}

