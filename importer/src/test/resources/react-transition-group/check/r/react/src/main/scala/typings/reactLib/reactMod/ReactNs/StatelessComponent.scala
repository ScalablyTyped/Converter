package typings
package reactLib.reactMod.ReactNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends js.Object {
  var defaultProps: js.UndefOr[stdLib.Partial[P]] = js.native
  var displayName: js.UndefOr[java.lang.String] = js.native
  def apply(props: P with reactLib.Anon_Children): ReactElement[_] | scala.Null = js.native
  def apply(props: P with reactLib.Anon_Children, context: js.Any): ReactElement[_] | scala.Null = js.native
}

