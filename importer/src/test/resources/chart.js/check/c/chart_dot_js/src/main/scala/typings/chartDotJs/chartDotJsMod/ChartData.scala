package typings.chartDotJs.chartDotJsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ChartData extends js.Object {
  var labels: js.UndefOr[js.Array[String | js.Array[String]]] = js.undefined
}

object ChartData {
  @scala.inline
  def apply(labels: js.Array[String | js.Array[String]] = null): ChartData = {
    val __obj = js.Dynamic.literal()
    if (labels != null) __obj.updateDynamic("labels")(labels.asInstanceOf[js.Any])
    __obj.asInstanceOf[ChartData]
  }
}

