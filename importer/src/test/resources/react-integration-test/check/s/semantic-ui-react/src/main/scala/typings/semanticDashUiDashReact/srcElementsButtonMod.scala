package typings.semanticDashUiDashReact

import typings.react.reactMod.StatelessComponent
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
    var Content: StatelessComponent[ButtonContentProps] = js.native
    var Group: StatelessComponent[ButtonGroupProps] = js.native
    var Or: StatelessComponent[ButtonOrProps] = js.native
  }
  
}

