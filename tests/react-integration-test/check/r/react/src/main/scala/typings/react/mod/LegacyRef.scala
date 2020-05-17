package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - java.lang.String
  - typings.react.mod.Ref[T]
*/
trait LegacyRef[T] extends js.Object

object LegacyRef {
  @scala.inline
  implicit def apply[T](value: js.Function1[/* instance */ T | Null, Unit]): LegacyRef[T] = value.asInstanceOf[LegacyRef[T]]
  @scala.inline
  implicit def apply[T](value: RefObject[T]): LegacyRef[T] = value.asInstanceOf[LegacyRef[T]]
  @scala.inline
  implicit def apply[T](value: String): LegacyRef[T] = value.asInstanceOf[LegacyRef[T]]
  @scala.inline
  implicit def fromOrNull[T, T_](value: T_ | Null)(implicit ev: T_ => LegacyRef[T]): LegacyRef[T] = if (value != null) ev(value.asInstanceOf[T_]) else null.asInstanceOf[LegacyRef[T]]
}

