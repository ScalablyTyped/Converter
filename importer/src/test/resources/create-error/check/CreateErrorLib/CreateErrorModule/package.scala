package ScalablyTyped
package CreateErrorLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object CreateErrorModule {
  type Err = StdlibLib.Error
  type Error[T <: CreateErrorLib.CreateErrorModule.Err] = CreateErrorLib.CreateErrorModule.CreateErrorNamespace.Error[T]
}
