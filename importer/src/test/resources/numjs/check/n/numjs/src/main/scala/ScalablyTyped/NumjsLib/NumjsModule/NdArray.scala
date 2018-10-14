package ScalablyTyped
package NumjsLib.NumjsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait NdArray[T]
  extends NdarrayLib.NdarrayModule.ndarray[T] {
  @JSName("T")
  var T_NdArray: NdArray[T]
  var ndim: scala.Double
  def slice(args: scala.Double*): NdArray[T]
}

