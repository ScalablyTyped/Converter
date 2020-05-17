package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type ComponentState = js.Object
  type DOMFactory[P /* <: typings.react.mod.DOMAttributes[T] */, T /* <: typings.std.Element */] = js.Function2[
    /* props */ js.UndefOr[(typings.react.mod.ClassAttributes[T] with P) | scala.Null], 
    /* repeated */ typings.react.mod.ReactNode, 
    typings.react.mod.DOMElement[P, T]
  ]
  type SFC[P] = typings.react.mod.StatelessComponent[P]
  type SVGProps[T] = typings.react.mod.ClassAttributes[T]
}
