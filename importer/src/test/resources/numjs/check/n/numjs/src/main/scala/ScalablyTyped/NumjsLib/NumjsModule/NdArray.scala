package ScalablyTyped
package NumjsLib
package NumjsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* RemoveDifficultStuff */
trait NdArray[T] extends NdarrayLib.NdarrayModule.ndarray[T] {
  @JSName("T")
  val T_NdArray: NumjsLib.NumjsModule.NdArray[T]
  val ndim: scala.Double
  def slice(args: scala.Double*): NumjsLib.NumjsModule.NdArray[T]
}

