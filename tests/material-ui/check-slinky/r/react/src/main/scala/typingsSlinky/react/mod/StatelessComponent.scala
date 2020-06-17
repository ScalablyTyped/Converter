package typingsSlinky.react.mod

import typingsSlinky.react.anon.Children
import typingsSlinky.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends js.Object {
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
  def apply(props: P with Children): slinky.core.facade.ReactElement | Null = js.native
  def apply(props: P with Children, context: js.Any): slinky.core.facade.ReactElement | Null = js.native
}

