package typingsSlinky.react.mod

import typingsSlinky.react.AnonChildren
import typingsSlinky.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends ComponentType[P] {
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
  def apply(props: P with AnonChildren): slinky.core.facade.ReactElement | Null = js.native
  def apply(props: P with AnonChildren, context: js.Any): slinky.core.facade.ReactElement | Null = js.native
}

