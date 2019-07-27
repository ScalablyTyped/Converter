package typings.reactLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactMod {
  type ComponentState = js.Object
  type Key = String | Double
  type ReactNode = js.UndefOr[String | Double | Boolean]
  type SFC[P] = StatelessComponent[P]
}
