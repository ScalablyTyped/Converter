package typings
package chartDotJsLib.chartDotJsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Chart extends js.Object {
  var clear: js.Function0[js.Object]
  var data: chartDotJsLib.chartDotJsMod.ChartNs.ChartData
  var destroy: js.Function0[js.Object]
  var generateLegend: js.Function0[js.Object]
  var getDatasetAtEvent: js.Function1[/* e */ js.Any, js.Array[js.Object]]
  var getElementAtEvent: js.Function1[/* e */ js.Any, js.Object]
  var getElementsAtEvent: js.Function1[/* e */ js.Any, js.Array[js.Object]]
  var render: js.Function2[/* duration */ js.UndefOr[js.Any], /* lazy */ js.UndefOr[js.Any], js.Object]
  var resize: js.Function0[js.Object]
  var stop: js.Function0[js.Object]
  var toBase64: js.Function0[java.lang.String]
  var update: js.Function2[/* duration */ js.UndefOr[js.Any], /* lazy */ js.UndefOr[js.Any], js.Object]
}

