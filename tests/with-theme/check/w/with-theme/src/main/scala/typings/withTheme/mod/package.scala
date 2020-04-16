package typings.withTheme

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type ConsistentWith[T, U] = typings.std.Pick[U, /* keyof T */ java.lang.String]
}
