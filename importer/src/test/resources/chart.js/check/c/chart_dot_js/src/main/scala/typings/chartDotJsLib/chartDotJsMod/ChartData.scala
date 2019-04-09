package typings
package chartDotJsLib.chartDotJsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ChartData extends js.Object {
  var labels: js.UndefOr[js.Array[java.lang.String | js.Array[java.lang.String]]] = js.undefined
}

object ChartData {
  @scala.inline
  def apply(labels: js.Array[java.lang.String | js.Array[java.lang.String]] = null): ChartData = {
    val __obj = js.Dynamic.literal()
    if (labels != null) __obj.updateDynamic("labels")(labels)
    __obj.asInstanceOf[ChartData]
  }
}

