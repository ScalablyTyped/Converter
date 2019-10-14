package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`16:9`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`21:9`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`4:3`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.vimeo
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.youtube
import typings.semanticDashUiDashReact.srcElementsIconIconMod.IconProps
import typings.semanticDashUiDashReact.srcGenericMod.HtmlIframeProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcModulesEmbedEmbedMod.EmbedProps
import typings.semanticDashUiDashReact.srcModulesEmbedMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Embed {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    aspectRatio: `4:3` | `16:9` | `21:9` = null,
    autoplay: js.UndefOr[Boolean] = js.undefined,
    brandedUI: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: String = null,
    content: SemanticShorthandContent = null,
    defaultActive: js.UndefOr[Boolean] = js.undefined,
    hd: js.UndefOr[Boolean] = js.undefined,
    icon: SemanticShorthandItem[IconProps] = null,
    id: String = null,
    iframe: SemanticShorthandItem[HtmlIframeProps] = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ EmbedProps) => Callback = null,
    placeholder: String = null,
    source: youtube | vimeo = null,
    url: String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[EmbedProps, default, Unit, EmbedProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (aspectRatio != null) __obj.updateDynamic("aspectRatio")(aspectRatio.asInstanceOf[js.Any])
    if (!js.isUndefined(autoplay)) __obj.updateDynamic("autoplay")(autoplay)
    if (!js.isUndefined(brandedUI)) __obj.updateDynamic("brandedUI")(brandedUI)
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultActive)) __obj.updateDynamic("defaultActive")(defaultActive)
    if (!js.isUndefined(hd)) __obj.updateDynamic("hd")(hd)
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (id != null) __obj.updateDynamic("id")(id)
    if (iframe != null) __obj.updateDynamic("iframe")(iframe.asInstanceOf[js.Any])
        if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesEmbedEmbedMod.EmbedProps) => onClick(t0, t1).runNow())))
    if (placeholder != null) __obj.updateDynamic("placeholder")(placeholder)
    if (source != null) __obj.updateDynamic("source")(source.asInstanceOf[js.Any])
    if (url != null) __obj.updateDynamic("url")(url)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesEmbedEmbedMod.EmbedProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesEmbedMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesEmbedMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesEmbedEmbedMod.EmbedProps])(children: _*)
  }
}

