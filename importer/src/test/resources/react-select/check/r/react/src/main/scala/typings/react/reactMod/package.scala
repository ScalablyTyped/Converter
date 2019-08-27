package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactMod {
  import org.scalablytyped.runtime.UndefOr

  type ComponentState = js.Object
  type Key = String | Double
  type ReactNode = UndefOr[String | Double | Boolean]
  type SFC[P] = StatelessComponent[P]
}
