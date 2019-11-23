package typings.react.reactMod

import japgolly.scalajs.react.raw.React.Element
import typings.react.Anon_Children
import typings.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends ComponentType[P] {
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
  def apply(props: P with Anon_Children): Element | Null = js.native
  def apply(props: P with Anon_Children, context: js.Any): Element | Null = js.native
}

