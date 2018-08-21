package ScalablyTyped.runtime

import scala.scalajs.js

@js.native
trait TopLevel[T] extends js.Any

object TopLevel {
  @inline implicit def asT[T](t: TopLevel[T]): T = t.asInstanceOf[T]
  @inline implicit final class TopLevelSetter[T](private var tl: TopLevel[T]) {
    def set(value: T): Unit =
      tl = value.asInstanceOf[TopLevel[T]]
  }
}
