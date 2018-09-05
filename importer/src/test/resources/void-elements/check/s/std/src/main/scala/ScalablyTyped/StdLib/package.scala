package ScalablyTyped

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object StdLib {
  type Partial[T] = StdLib.StdLibStrings.Partial with T
  type Record[K /* <: java.lang.String */, T] = StdLib.StdLibStrings.Record with js.Any
}
