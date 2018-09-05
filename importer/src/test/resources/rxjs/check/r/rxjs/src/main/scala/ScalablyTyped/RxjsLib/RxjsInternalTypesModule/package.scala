package ScalablyTyped
package RxjsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object RxjsInternalTypesModule {
  type OperatorFunction[T, R] = UnaryFunction[RxjsLib.RxjsInternalObservableModule.Observable[T], RxjsLib.RxjsInternalObservableModule.Observable[R]]
  type PartialObserver[T] = NextObserver[T] | ErrorObserver[T] | CompletionObserver[T]
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
}
