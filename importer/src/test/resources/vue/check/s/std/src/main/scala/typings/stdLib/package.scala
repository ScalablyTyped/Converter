package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object stdLib {
  type Element = Node
  type HTMLElement = Element
  type Readonly[T] = stdLib.stdLibStrings.Readonly with T
  type Record[K /* <: java.lang.String */, T] = stdLib.stdLibStrings.Record with js.Any
}
