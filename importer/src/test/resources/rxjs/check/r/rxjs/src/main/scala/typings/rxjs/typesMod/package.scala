package typings.rxjs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typesMod {
  import typings.rxjs.observableMod.Observable

  type OperatorFunction[T, R] = UnaryFunction[Observable[T], Observable[R]]
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
}
