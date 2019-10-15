package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.SearchResultProps
import typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object SearchResult {
  def apply(
    title: String,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    description: String = null,
    id: Double | String = null,
    image: String = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ SearchResultProps) => Callback = null,
    price: String = null,
    renderer: /* props */ SearchResultProps => Callback = null
  ): UnmountedWithRoot[SearchResultProps, default, Unit, SearchResultProps] = {
    val __obj = js.Dynamic.literal(title = title)
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description)
    if (id != null) __obj.updateDynamic("id")(id.asInstanceOf[js.Any])
    if (image != null) __obj.updateDynamic("image")(image)
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.SearchResultProps) => onClick(t0, t1).runNow())))
    if (price != null) __obj.updateDynamic("price")(price)
    if (renderer != null) __obj.updateDynamic("renderer")(js.Any.fromFunction1(((t0: /* props */ typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.SearchResultProps) => renderer(t0).runNow())))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.SearchResultProps, 
  japgolly.scalajs.react.Children.None, 
  typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.SearchResultProps])
  }
}

