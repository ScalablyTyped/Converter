package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.RefHandle
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - js.Function1[/ * instance * / T | scala.Null, scala.Unit]
  - typingsJapgolly.react.mod.RefObject[T]
  - scala.Null
*/
trait Ref[T] extends js.Object

object Ref {
  @scala.inline
  implicit def apply[T](value: js.Function1[/* instance */ T | Null, Unit]): japgolly.scalajs.react.raw.React.Ref = value.asInstanceOf[japgolly.scalajs.react.raw.React.Ref]
  @scala.inline
  implicit def apply[T](value: RefHandle[T]): japgolly.scalajs.react.raw.React.Ref = value.asInstanceOf[japgolly.scalajs.react.raw.React.Ref]
  @scala.inline
  implicit def fromOrNull[T, T_](value: T_ | Null)(implicit ev: T_ => japgolly.scalajs.react.raw.React.Ref): japgolly.scalajs.react.raw.React.Ref = if (value != null) ev(value.asInstanceOf[T_]) else null.asInstanceOf[japgolly.scalajs.react.raw.React.Ref]
}

