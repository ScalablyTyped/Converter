package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object stdLib {
  type Partial[T] = stdLib.stdLibStrings.Partial with T
  type Record[K /* <: java.lang.String */, T] = org.scalablytyped.runtime.StringDictionary[K]
}
