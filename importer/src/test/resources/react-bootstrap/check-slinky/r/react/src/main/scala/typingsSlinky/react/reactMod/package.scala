package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactMod {
  import slinky.core.ReactComponentClass

  type ComponentState = js.Object
  type Key = String | Double
  type ReactNode = js.UndefOr[String | Double | Boolean]
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  type SFC[P] = ReactComponentClass[P]
  type SVGAttributes[T] = DOMAttributes[T]
}
