package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Element
import typingsJapgolly.react.anon.Children
import typingsJapgolly.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait StatelessComponent[P] extends js.Object {
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
  def apply(props: P with Children): Element | Null = js.native
  def apply(props: P with Children, context: js.Any): Element | Null = js.native
}

