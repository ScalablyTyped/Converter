package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.RefObject
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.modulesSidebarMod.default
import typings.semanticUiReact.modulesSidebarSidebarMod.SidebarProps
import typings.semanticUiReact.semanticUiReactStrings.`scale down`
import typings.semanticUiReact.semanticUiReactStrings.`slide along`
import typings.semanticUiReact.semanticUiReactStrings.`slide out`
import typings.semanticUiReact.semanticUiReactStrings.overlay
import typings.semanticUiReact.semanticUiReactStrings.push
import typings.semanticUiReact.semanticUiReactStrings.uncover
import typings.std.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, direction, width */
object Sidebar
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticUiReact.modulesSidebarMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    animation: overlay | push | (`scale down`) | uncover | (`slide out`) | (`slide along`) = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    onHidden: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SidebarProps) => Unit = null,
    onHide: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SidebarProps) => Unit = null,
    onShow: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SidebarProps) => Unit = null,
    onVisible: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SidebarProps) => Unit = null,
    target: js.Object | RefObject[HTMLElement] = null,
    visible: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (animation != null) __obj.updateDynamic("animation")(animation.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (onHidden != null) __obj.updateDynamic("onHidden")(js.Any.fromFunction2(onHidden))
    if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction2(onHide))
    if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction2(onShow))
    if (onVisible != null) __obj.updateDynamic("onVisible")(js.Any.fromFunction2(onVisible))
    if (target != null) __obj.updateDynamic("target")(target.asInstanceOf[js.Any])
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = SidebarProps
}

