package ScalablyTyped
package NumjsLib.NumjsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* RemoveDifficultStuff */
trait NdArray[T] extends NdarrayLib.NdarrayModule.ndarray[T] {
  @JSName("T")
  val T_NdArray: NdArray[T]
  val ndim: scala.Double
  def slice(args: scala.Double*): NdArray[T]
}

