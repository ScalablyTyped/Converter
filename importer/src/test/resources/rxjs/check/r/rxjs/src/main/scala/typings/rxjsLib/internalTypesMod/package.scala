package typings.rxjsLib

import typings.rxjsLib.internalObservableMod.Observable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object internalTypesMod {
  type OperatorFunction[T, R] = UnaryFunction[Observable[T], Observable[R]]
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
}
