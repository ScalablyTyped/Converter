package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import slinky.core.ReactComponentClass

  type ComponentState = js.Object
  type Key = String | Double
  type ReactNode = js.UndefOr[String | Double | Boolean]
  type SFC[P] = ReactComponentClass[P]
  type SVGAttributes[T] = DOMAttributes[T]
}
