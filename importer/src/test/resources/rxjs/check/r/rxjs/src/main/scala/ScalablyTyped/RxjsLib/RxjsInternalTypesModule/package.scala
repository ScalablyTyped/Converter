package ScalablyTyped
package RxjsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object RxjsInternalTypesModule {
  type PartialObserver[T] = RxjsLib.RxjsInternalTypesModule.NextObserver[T] | RxjsLib.RxjsInternalTypesModule.ErrorObserver[T] | RxjsLib.RxjsInternalTypesModule.CompletionObserver[T]
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
}
