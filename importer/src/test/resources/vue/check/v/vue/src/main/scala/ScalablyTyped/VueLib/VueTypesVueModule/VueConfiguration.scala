package ScalablyTyped
package VueLib.VueTypesVueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait VueConfiguration extends js.Object {
  val devtools: scala.Boolean
  val ignoredElements: StdLib.Array[java.lang.String | StdLib.RegExp]
  val keyCodes: ScalablyTyped.runtime.StringDictionary[scala.Double | StdLib.Array[scala.Double]]
  val optionMergeStrategies: js.Any
  val performance: scala.Boolean
  val productionTip: scala.Boolean
  val silent: scala.Boolean
  def errorHandler(err: StdLib.Error, vm: Vue, info: java.lang.String): scala.Unit
  def warnHandler(msg: java.lang.String, vm: Vue, trace: java.lang.String): scala.Unit
}

