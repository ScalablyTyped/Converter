package ScalablyTyped
package NumjsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object NumjsModule {
  type NdType[T] = NdarrayLib.NdarrayModule.ndarrayNamespace.DataType | NdarrayLib.NdarrayModule.ndarrayNamespace.Data[T]
}
