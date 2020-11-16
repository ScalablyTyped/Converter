package typings.rxjs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object typesMod {
  
  type OperatorFunction[T, R] = typings.rxjs.typesMod.UnaryFunction[typings.rxjs.observableMod.Observable[T], typings.rxjs.observableMod.Observable[R]]
  
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
}
