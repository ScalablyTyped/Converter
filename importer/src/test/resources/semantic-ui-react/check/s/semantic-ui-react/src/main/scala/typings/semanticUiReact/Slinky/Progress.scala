package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.semanticUiReact.genericMod.HtmlLabelProps
import typings.semanticUiReact.genericMod.SemanticCOLORS
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesProgressMod.default
import typings.semanticUiReact.modulesProgressProgressMod.ProgressProps
import typings.semanticUiReact.semanticUiReactStrings.big
import typings.semanticUiReact.semanticUiReactStrings.bottom
import typings.semanticUiReact.semanticUiReactStrings.large
import typings.semanticUiReact.semanticUiReactStrings.medium
import typings.semanticUiReact.semanticUiReactStrings.percent
import typings.semanticUiReact.semanticUiReactStrings.ratio
import typings.semanticUiReact.semanticUiReactStrings.small
import typings.semanticUiReact.semanticUiReactStrings.tiny
import typings.semanticUiReact.semanticUiReactStrings.top
import typings.semanticUiReact.semanticUiReactStrings.value
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, disabled, value */
object Progress
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticUiReact.modulesProgressMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    attached: top | bottom = null,
    autoSuccess: js.UndefOr[Boolean] = js.undefined,
    color: SemanticCOLORS = null,
    content: SemanticShorthandContent = null,
    error: js.UndefOr[Boolean] = js.undefined,
    indicating: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    label: SemanticShorthandItem[HtmlLabelProps] = null,
    percent: Double | String = null,
    precision: Int | Double = null,
    progress: Boolean | percent | ratio | value = null,
    size: tiny | small | medium | large | big = null,
    success: js.UndefOr[Boolean] = js.undefined,
    total: Double | String = null,
    warning: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(autoSuccess)) __obj.updateDynamic("autoSuccess")(autoSuccess)
    if (color != null) __obj.updateDynamic("color")(color)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(error)) __obj.updateDynamic("error")(error)
    if (!js.isUndefined(indicating)) __obj.updateDynamic("indicating")(indicating)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (percent != null) __obj.updateDynamic("percent")(percent.asInstanceOf[js.Any])
    if (precision != null) __obj.updateDynamic("precision")(precision.asInstanceOf[js.Any])
    if (progress != null) __obj.updateDynamic("progress")(progress.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (!js.isUndefined(success)) __obj.updateDynamic("success")(success)
    if (total != null) __obj.updateDynamic("total")(total.asInstanceOf[js.Any])
    if (!js.isUndefined(warning)) __obj.updateDynamic("warning")(warning)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ProgressProps
}

