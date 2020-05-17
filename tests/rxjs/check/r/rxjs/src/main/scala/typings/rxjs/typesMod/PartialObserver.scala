package typings.rxjs.typesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.rxjs.typesMod.NextObserver[T]
  - typings.rxjs.typesMod.ErrorObserver[T]
  - typings.rxjs.typesMod.CompletionObserver[T]
*/
trait PartialObserver[T] extends js.Object

object PartialObserver {
  @scala.inline
  implicit def apply[T](value: CompletionObserver[T]): PartialObserver[T] = value.asInstanceOf[PartialObserver[T]]
  @scala.inline
  implicit def apply[T](value: ErrorObserver[T]): PartialObserver[T] = value.asInstanceOf[PartialObserver[T]]
  @scala.inline
  implicit def apply[T](value: NextObserver[T]): PartialObserver[T] = value.asInstanceOf[PartialObserver[T]]
}

