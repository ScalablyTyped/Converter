package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.semanticUiReact.elementsIconIconMod.IconProps
import typings.semanticUiReact.genericMod.HtmlIframeProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesEmbedEmbedMod.EmbedProps
import typings.semanticUiReact.modulesEmbedMod.default
import typings.semanticUiReact.semanticUiReactStrings.`16:9`
import typings.semanticUiReact.semanticUiReactStrings.`21:9`
import typings.semanticUiReact.semanticUiReactStrings.`4:3`
import typings.semanticUiReact.semanticUiReactStrings.vimeo
import typings.semanticUiReact.semanticUiReactStrings.youtube
import typings.std.HTMLDivElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, color, id, placeholder */
object Embed
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticUiReact.modulesEmbedMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    aspectRatio: `4:3` | `16:9` | `21:9` = null,
    autoplay: js.UndefOr[Boolean] = js.undefined,
    brandedUI: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    defaultActive: js.UndefOr[Boolean] = js.undefined,
    hd: js.UndefOr[Boolean] = js.undefined,
    icon: SemanticShorthandItem[IconProps] = null,
    iframe: SemanticShorthandItem[HtmlIframeProps] = null,
    onClick: (/* event */ MouseEvent[HTMLDivElement, NativeMouseEvent], /* data */ EmbedProps) => Unit = null,
    source: youtube | vimeo = null,
    url: String = null
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (aspectRatio != null) __obj.updateDynamic("aspectRatio")(aspectRatio.asInstanceOf[js.Any])
    if (!js.isUndefined(autoplay)) __obj.updateDynamic("autoplay")(autoplay)
    if (!js.isUndefined(brandedUI)) __obj.updateDynamic("brandedUI")(brandedUI)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultActive)) __obj.updateDynamic("defaultActive")(defaultActive)
    if (!js.isUndefined(hd)) __obj.updateDynamic("hd")(hd)
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (iframe != null) __obj.updateDynamic("iframe")(iframe.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (source != null) __obj.updateDynamic("source")(source.asInstanceOf[js.Any])
    if (url != null) __obj.updateDynamic("url")(url)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = EmbedProps
}

