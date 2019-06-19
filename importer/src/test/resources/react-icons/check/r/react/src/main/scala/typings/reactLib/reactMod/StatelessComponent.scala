package typings
package reactLib.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends ComponentType[P] {
  var defaultProps: js.UndefOr[stdLib.Partial[P]] = js.native
  var displayName: js.UndefOr[java.lang.String] = js.native
  def apply(props: P with reactLib.Anon_Children): ReactElement | scala.Null = js.native
  def apply(props: P with reactLib.Anon_Children, context: js.Any): ReactElement | scala.Null = js.native
}

