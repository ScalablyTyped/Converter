package typings
package chartDotJsLib.chartDotJsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("chart.js", JSImport.Namespace)
@js.native
class namespaced protected () extends Chart {
  def this(context: java.lang.String, options: js.Any) = this()
  def this(context: stdLib.ArrayLike[stdLib.CanvasRenderingContext2D | stdLib.HTMLCanvasElement], options: js.Any) = this()
  def this(context: stdLib.CanvasRenderingContext2D, options: js.Any) = this()
  def this(context: stdLib.HTMLCanvasElement, options: js.Any) = this()
  /* CompleteClass */
  override var clear: js.Function0[js.Object] = js.native
  /* CompleteClass */
  override var data: chartDotJsLib.chartDotJsMod.ChartNs.ChartData = js.native
  /* CompleteClass */
  override var destroy: js.Function0[js.Object] = js.native
  /* CompleteClass */
  override var generateLegend: js.Function0[js.Object] = js.native
  /* CompleteClass */
  override var getDatasetAtEvent: js.Function1[/* e */ js.Any, js.Array[js.Object]] = js.native
  /* CompleteClass */
  override var getElementAtEvent: js.Function1[/* e */ js.Any, js.Object] = js.native
  /* CompleteClass */
  override var getElementsAtEvent: js.Function1[/* e */ js.Any, js.Array[js.Object]] = js.native
  /* CompleteClass */
  override var render: js.Function2[/* duration */ js.UndefOr[js.Any], /* lazy */ js.UndefOr[js.Any], js.Object] = js.native
  /* CompleteClass */
  override var resize: js.Function0[js.Object] = js.native
  /* CompleteClass */
  override var stop: js.Function0[js.Object] = js.native
  /* CompleteClass */
  override var toBase64: js.Function0[java.lang.String] = js.native
  /* CompleteClass */
  override var update: js.Function2[/* duration */ js.UndefOr[js.Any], /* lazy */ js.UndefOr[js.Any], js.Object] = js.native
}

/* static members */
@JSImport("chart.js", JSImport.Namespace)
@js.native
object namespaced extends js.Object {
  val Chart: chartDotJsLib.Anon_Chart = js.native
  var controllers: org.scalablytyped.runtime.StringDictionary[js.Any] = js.native
  var defaults: chartDotJsLib.Anon_Global = js.native
}

