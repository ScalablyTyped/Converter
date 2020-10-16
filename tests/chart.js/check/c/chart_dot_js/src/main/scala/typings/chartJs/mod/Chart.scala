package typings.chartJs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Chart extends js.Object {
  def clear(): js.Object = js.native
  var data: ChartData = js.native
  def destroy(): js.Object = js.native
  def generateLegend(): js.Object = js.native
  def getDatasetAtEvent(e: js.Any): js.Array[js.Object] = js.native
  def getElementAtEvent(e: js.Any): js.Object = js.native
  def getElementsAtEvent(e: js.Any): js.Array[js.Object] = js.native
  def render(): js.Object = js.native
  def render(duration: js.UndefOr[scala.Nothing], `lazy`: js.Any): js.Object = js.native
  def render(duration: js.Any): js.Object = js.native
  def render(duration: js.Any, `lazy`: js.Any): js.Object = js.native
  def resize(): js.Object = js.native
  def stop(): js.Object = js.native
  def toBase64(): String = js.native
  def update(): js.Object = js.native
  def update(duration: js.UndefOr[scala.Nothing], `lazy`: js.Any): js.Object = js.native
  def update(duration: js.Any): js.Object = js.native
  def update(duration: js.Any, `lazy`: js.Any): js.Object = js.native
}

