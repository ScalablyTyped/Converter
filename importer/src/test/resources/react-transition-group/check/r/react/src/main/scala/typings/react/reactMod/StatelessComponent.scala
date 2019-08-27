package typings.react.reactMod

import org.scalablytyped.runtime.NullOr
import org.scalablytyped.runtime.UndefOr
import typings.react.Anon_Children
import typings.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends ComponentType[P] {
  var defaultProps: UndefOr[Partial[P]] = js.native
  var displayName: UndefOr[String] = js.native
  def apply(props: P with Anon_Children): NullOr[ReactElement] = js.native
  def apply(props: P with Anon_Children, context: js.Any): NullOr[ReactElement] = js.native
}

