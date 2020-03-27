package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type ComponentState = js.Object
  type Key = java.lang.String | scala.Double
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  type SFC[P] = typings.react.mod.StatelessComponent[P]
  type SVGAttributes[T] = typings.react.mod.DOMAttributes[T]
}
