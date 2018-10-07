package ScalablyTyped
package VueLib.VueTypesVueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait VueConfiguration extends js.Object {
  var devtools: scala.Boolean
  var ignoredElements: StdLib.Array[java.lang.String | StdLib.RegExp]
  var keyCodes: ScalablyTyped.runtime.StringDictionary[scala.Double | StdLib.Array[scala.Double]]
  var optionMergeStrategies: js.Any
  var performance: scala.Boolean
  var productionTip: scala.Boolean
  var silent: scala.Boolean
  def errorHandler(err: StdLib.Error, vm: Vue, info: java.lang.String): scala.Unit
  def warnHandler(msg: java.lang.String, vm: Vue, trace: java.lang.String): scala.Unit
}

