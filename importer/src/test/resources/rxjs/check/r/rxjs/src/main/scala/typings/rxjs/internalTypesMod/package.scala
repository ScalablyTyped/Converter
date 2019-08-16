package typings.rxjs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object internalTypesMod {
  import typings.rxjs.internalObservableMod.Observable

  type OperatorFunction[T, R] = UnaryFunction[Observable[T], Observable[R]]
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
}
