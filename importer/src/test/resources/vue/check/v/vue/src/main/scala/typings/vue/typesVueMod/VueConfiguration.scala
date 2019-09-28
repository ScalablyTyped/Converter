package typings.vue.typesVueMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js.annotation.ScalaJSDefined
import typings.std.Error
import typings.std.RegExp
import scala.scalajs.js
import scala.scalajs.js.`|`

trait VueConfiguration extends js.Object {
  var devtools: Boolean
  var ignoredElements: js.Array[String | RegExp]
  var keyCodes: StringDictionary[Double | js.Array[Double]]
  var optionMergeStrategies: js.Any
  var performance: Boolean
  var productionTip: Boolean
  var silent: Boolean
  def errorHandler(err: Error, vm: Vue, info: String): Unit
  def warnHandler(msg: String, vm: Vue, trace: String): Unit
}

object VueConfiguration {
  @inline
  def apply(
    devtools: Boolean,
    errorHandler: (Error, Vue, String) => Unit,
    ignoredElements: js.Array[String | RegExp],
    keyCodes: StringDictionary[Double | js.Array[Double]],
    optionMergeStrategies: js.Any,
    performance: Boolean,
    productionTip: Boolean,
    silent: Boolean,
    warnHandler: (String, Vue, String) => Unit
  ): VueConfiguration = {
    val __obj = js.Dynamic.literal(devtools = devtools, errorHandler = js.Any.fromFunction3(errorHandler), ignoredElements = ignoredElements, keyCodes = keyCodes, optionMergeStrategies = optionMergeStrategies, performance = performance, productionTip = productionTip, silent = silent, warnHandler = js.Any.fromFunction3(warnHandler))
  
    __obj.asInstanceOf[VueConfiguration]
  }
}

