package typings.semanticDashUiDashReact.srcModulesStickyStickyMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.HTMLElement
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.ReactNode
import typings.react.reactMod.Ref
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StickyProps
  extends StrictStickyProps
     with /* key */ StringDictionary[js.Any]

object StickyProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    bottomOffset: Int | Double = null,
    children: ReactNode = null,
    className: String = null,
    context: js.Object | Ref[HTMLElement] = null,
    offset: Int | Double = null,
    onBottom: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ StickyProps) => Unit = null,
    onStick: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ StickyProps) => Unit = null,
    onTop: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ StickyProps) => Unit = null,
    onUnstick: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ StickyProps) => Unit = null,
    pushing: js.UndefOr[Boolean] = js.undefined,
    scrollContext: js.Object | Ref[HTMLElement] = null,
    styleElement: js.Object = null
  ): StickyProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (bottomOffset != null) __obj.updateDynamic("bottomOffset")(bottomOffset.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (context != null) __obj.updateDynamic("context")(context.asInstanceOf[js.Any])
    if (offset != null) __obj.updateDynamic("offset")(offset.asInstanceOf[js.Any])
    if (onBottom != null) __obj.updateDynamic("onBottom")(js.Any.fromFunction2(onBottom))
    if (onStick != null) __obj.updateDynamic("onStick")(js.Any.fromFunction2(onStick))
    if (onTop != null) __obj.updateDynamic("onTop")(js.Any.fromFunction2(onTop))
    if (onUnstick != null) __obj.updateDynamic("onUnstick")(js.Any.fromFunction2(onUnstick))
    if (!js.isUndefined(pushing)) __obj.updateDynamic("pushing")(pushing)
    if (scrollContext != null) __obj.updateDynamic("scrollContext")(scrollContext.asInstanceOf[js.Any])
    if (styleElement != null) __obj.updateDynamic("styleElement")(styleElement)
    __obj.asInstanceOf[StickyProps]
  }
}
