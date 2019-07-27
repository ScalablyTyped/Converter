package typings
package chartDotJsLib.chartDotJsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Chart extends js.Object {
  var data: ChartData = js.native
  def clear(): js.Object = js.native
  def destroy(): js.Object = js.native
  def generateLegend(): js.Object = js.native
  def getDatasetAtEvent(e: js.Any): js.Array[js.Object] = js.native
  def getElementAtEvent(e: js.Any): js.Object = js.native
  def getElementsAtEvent(e: js.Any): js.Array[js.Object] = js.native
  def render(): js.Object = js.native
  def render(duration: js.Any): js.Object = js.native
  def render(duration: js.Any, `lazy`: js.Any): js.Object = js.native
  def resize(): js.Object = js.native
  def stop(): js.Object = js.native
  def toBase64(): String = js.native
  def update(): js.Object = js.native
  def update(duration: js.Any): js.Object = js.native
  def update(duration: js.Any, `lazy`: js.Any): js.Object = js.native
}

