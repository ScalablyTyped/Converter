package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object mod {
  
  type ComponentState = js.Object
  
  type DOMFactory[P /* <: typings.react.mod.DOMAttributes[T] */, T /* <: typings.std.Element */] = js.Function2[
    /* props */ js.UndefOr[(typings.react.mod.ClassAttributes[T] with P) | scala.Null], 
    /* repeated */ typings.react.mod.ReactNode, 
    typings.react.mod.DOMElement[P, T]
  ]
  
  type Key = java.lang.String | scala.Double
  
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  
  type SFC[P] = typings.react.mod.StatelessComponent[P]
  
  type SVGProps[T] = typings.react.mod.ClassAttributes[T]
}
