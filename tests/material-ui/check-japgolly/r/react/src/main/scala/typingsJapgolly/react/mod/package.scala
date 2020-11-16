package typingsJapgolly.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object mod {
  
  type ComponentState = js.Object
  
  type ComponentType[P] = (japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object]) | typingsJapgolly.react.mod.StatelessComponent[P]
  
  type Key = java.lang.String | scala.Double
  
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  
  type SFC[P] = typingsJapgolly.react.mod.StatelessComponent[P]
  
  type SVGAttributes[T] = typingsJapgolly.react.mod.DOMAttributes[T]
}
