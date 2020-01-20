package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Element
import typingsJapgolly.react.AnonChildren
import typingsJapgolly.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StatelessComponent[P] extends ComponentType[P] {
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
  def apply(props: P with AnonChildren): Element | Null = js.native
  def apply(props: P with AnonChildren, context: js.Any): Element | Null = js.native
}

