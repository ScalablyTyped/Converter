package typingsSlinky.semanticUiReact

import slinky.core.ReactComponentClass
import typingsSlinky.semanticUiReact.elementsButtonButtonContentMod.ButtonContentProps
import typingsSlinky.semanticUiReact.elementsButtonButtonGroupMod.ButtonGroupProps
import typingsSlinky.semanticUiReact.elementsButtonButtonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/elements/Button", JSImport.Namespace)
@js.native
object elementsButtonMod extends js.Object {
  @js.native
  class default ()
    extends typingsSlinky.semanticUiReact.elementsButtonButtonMod.default
  
  /* static members */
  @js.native
  object default extends js.Object {
    var Content: ReactComponentClass[ButtonContentProps] = js.native
    var Group: ReactComponentClass[ButtonGroupProps] = js.native
    var Or: ReactComponentClass[ButtonOrProps] = js.native
  }
  
}

