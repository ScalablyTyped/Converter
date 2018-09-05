package ScalablyTyped

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object StdLib {
  type Element = Node
  type HTMLElement = Element
  type Readonly[T] = StdLib.StdLibStrings.Readonly with T
  type Record[K /* <: java.lang.String */, T] = StdLib.StdLibStrings.Record with js.Any
}
