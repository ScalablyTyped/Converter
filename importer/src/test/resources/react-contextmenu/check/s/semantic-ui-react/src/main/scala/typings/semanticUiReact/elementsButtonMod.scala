package typings.semanticUiReact

import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.elementsButtonButtonContentMod.ButtonContentProps
import typings.semanticUiReact.elementsButtonButtonGroupMod.ButtonGroupProps
import typings.semanticUiReact.elementsButtonButtonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/elements/Button", JSImport.Namespace)
@js.native
object elementsButtonMod extends js.Object {
  @js.native
  class default ()
    extends typings.semanticUiReact.elementsButtonButtonMod.default
  
  /* static members */
  @js.native
  object default extends js.Object {
    var Content: StatelessComponent[ButtonContentProps] = js.native
    var Group: StatelessComponent[ButtonGroupProps] = js.native
    var Or: StatelessComponent[ButtonOrProps] = js.native
  }
  
}

