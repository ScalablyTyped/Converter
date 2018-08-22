package ScalablyTyped
package ReactLib.ReactModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ReactNamespace {
  type Key = java.lang.String | scala.Double
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean | scala.Null]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
}
