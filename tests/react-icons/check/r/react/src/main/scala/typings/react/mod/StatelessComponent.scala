package typings.react.mod

import typings.react.anon.Children
import typings.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait StatelessComponent[P] extends ComponentType[P] {
  def apply(props: P with Children): ReactElement | Null = js.native
  def apply(props: P with Children, context: js.Any): ReactElement | Null = js.native
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
}

