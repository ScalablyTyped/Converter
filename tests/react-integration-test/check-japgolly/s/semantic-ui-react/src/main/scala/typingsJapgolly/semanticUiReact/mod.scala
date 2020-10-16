package typingsJapgolly.semanticUiReact

import typingsJapgolly.react.mod.StatelessComponent
import typingsJapgolly.semanticUiReact.buttonContentMod.ButtonContentProps
import typingsJapgolly.semanticUiReact.buttonGroupMod.ButtonGroupProps
import typingsJapgolly.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Namespace)
@js.native
object mod extends js.Object {
  /* static members */
  @js.native
  object default extends js.Object {
    var Content: StatelessComponent[ButtonContentProps] = js.native
    var Group: StatelessComponent[ButtonGroupProps] = js.native
    var Or: StatelessComponent[ButtonOrProps] = js.native
  }
  
  @js.native
  class default ()
    extends typingsJapgolly.semanticUiReact.buttonMod.default
  
}

