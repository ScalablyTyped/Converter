package typings.rxjs.mod.internal

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object types {
  import typings.rxjs.mod.internal.Observable.Observable

  type OperatorFunction[T, R] = UnaryFunction[Observable[T], Observable[R]]
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
}
