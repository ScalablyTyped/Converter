package typings.vue.vueMod

import org.scalablytyped.runtime.StringDictionary
import typings.std.Error
import typings.std.RegExp
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VueConfiguration extends js.Object {
  var devtools: Boolean = js.native
  var ignoredElements: js.Array[String | RegExp] = js.native
  var keyCodes: StringDictionary[Double | js.Array[Double]] = js.native
  var optionMergeStrategies: js.Any = js.native
  var performance: Boolean = js.native
  var productionTip: Boolean = js.native
  var silent: Boolean = js.native
  def errorHandler(err: Error, vm: Vue, info: String): Unit = js.native
  def warnHandler(msg: String, vm: Vue, trace: String): Unit = js.native
}

object VueConfiguration {
  @scala.inline
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
    val __obj = js.Dynamic.literal(devtools = devtools.asInstanceOf[js.Any], errorHandler = js.Any.fromFunction3(errorHandler), ignoredElements = ignoredElements.asInstanceOf[js.Any], keyCodes = keyCodes.asInstanceOf[js.Any], optionMergeStrategies = optionMergeStrategies.asInstanceOf[js.Any], performance = performance.asInstanceOf[js.Any], productionTip = productionTip.asInstanceOf[js.Any], silent = silent.asInstanceOf[js.Any], warnHandler = js.Any.fromFunction3(warnHandler))
    __obj.asInstanceOf[VueConfiguration]
  }
  @scala.inline
  implicit class VueConfigurationOps[Self <: VueConfiguration] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withDevtools(devtools: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("devtools")(devtools.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withErrorHandler(errorHandler: (Error, Vue, String) => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("errorHandler")(js.Any.fromFunction3(errorHandler))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIgnoredElements(ignoredElements: js.Array[String | RegExp]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ignoredElements")(ignoredElements.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withKeyCodes(keyCodes: StringDictionary[Double | js.Array[Double]]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("keyCodes")(keyCodes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptionMergeStrategies(optionMergeStrategies: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("optionMergeStrategies")(optionMergeStrategies.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPerformance(performance: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("performance")(performance.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withProductionTip(productionTip: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("productionTip")(productionTip.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSilent(silent: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("silent")(silent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withWarnHandler(warnHandler: (String, Vue, String) => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("warnHandler")(js.Any.fromFunction3(warnHandler))
        ret.asInstanceOf[Self]
    }
  }
  
}

