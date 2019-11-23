package typings.semanticDashUiDashReact

import slinky.core.ReactComponentClass
import typings.semanticDashUiDashReact.srcElementsButtonButtonContentMod.ButtonContentProps
import typings.semanticDashUiDashReact.srcElementsButtonButtonGroupMod.ButtonGroupProps
import typings.semanticDashUiDashReact.srcElementsButtonButtonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/elements/Button", JSImport.Namespace)
@js.native
object srcElementsButtonMod extends js.Object {
  @js.native
  class default ()
    extends typings.semanticDashUiDashReact.srcElementsButtonButtonMod.default
  
  /* static members */
  @js.native
  object default extends js.Object {
    var Content: ReactComponentClass[ButtonContentProps] = js.native
    var Group: ReactComponentClass[ButtonGroupProps] = js.native
    var Or: ReactComponentClass[ButtonOrProps] = js.native
  }
  
}

