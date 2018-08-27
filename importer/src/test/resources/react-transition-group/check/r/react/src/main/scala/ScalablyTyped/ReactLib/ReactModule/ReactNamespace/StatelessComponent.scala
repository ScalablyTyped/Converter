package ScalablyTyped
package ReactLib.ReactModule.ReactNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends js.Object {
  val defaultProps: js.UndefOr[StdLib.Partial[P]] = js.native
  val displayName: js.UndefOr[java.lang.String] = js.native
  def apply(props: P with ReactLib.Anon_Children): ReactElement[_] | scala.Null = js.native
  def apply(props: P with ReactLib.Anon_Children, context: js.Any): ReactElement[_] | scala.Null = js.native
}

