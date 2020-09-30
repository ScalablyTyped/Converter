package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object mod {
  type ComponentState = js.Object
  type ComponentType[P] = slinky.core.ReactComponentClass[P]
  type Key = java.lang.String | scala.Double
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  type SFC[P] = slinky.core.ReactComponentClass[P]
  type SVGAttributes[T] = typingsSlinky.react.mod.DOMAttributes[T]
}
