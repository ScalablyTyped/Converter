package typings.react.reactMod

import japgolly.scalajs.react.raw.React.Element
import typings.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait FunctionComponent[P] extends js.Object {
  var contextTypes: js.UndefOr[ValidationMap[_]] = js.native
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  var displayName: js.UndefOr[String] = js.native
  var propTypes: js.UndefOr[WeakValidationMap[P]] = js.native
  def apply(props: PropsWithChildren[P]): Element | Null = js.native
  def apply(props: PropsWithChildren[P], context: js.Any): Element | Null = js.native
}

