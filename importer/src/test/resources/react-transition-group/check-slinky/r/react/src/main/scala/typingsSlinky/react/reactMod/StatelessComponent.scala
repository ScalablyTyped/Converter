package typingsSlinky.react.reactMod

import typingsSlinky.react.Anon_Children
import typingsSlinky.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends ComponentType[P] {
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
  def apply(props: P with Anon_Children): slinky.core.facade.ReactElement | Null = js.native
  def apply(props: P with Anon_Children, context: js.Any): slinky.core.facade.ReactElement | Null = js.native
}

