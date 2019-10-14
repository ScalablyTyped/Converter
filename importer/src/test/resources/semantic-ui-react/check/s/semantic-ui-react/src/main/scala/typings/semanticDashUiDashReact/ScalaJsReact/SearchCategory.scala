package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import japgolly.scalajs.react.raw.React.ComponentClass
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesSearchSearchCategoryMod.SearchCategoryProps
import typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.SearchResultProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, name */
object SearchCategory {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    renderer: /* props */ SearchCategoryProps => Callback = null,
    results: js.Array[ComponentClass[SearchResultProps, js.Object]] = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedSimple[
    SearchCategoryProps, 
    MountedWithRawType[SearchCategoryProps, js.Object, RawMounted[SearchCategoryProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
        if (renderer != null) __obj.updateDynamic("renderer")(js.Any.fromFunction1(((t0: /* props */ typings.semanticDashUiDashReact.srcModulesSearchSearchCategoryMod.SearchCategoryProps) => renderer(t0).runNow())))
    if (results != null) __obj.updateDynamic("results")(results)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcModulesSearchSearchCategoryMod.SearchCategoryProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcModulesSearchSearchCategoryMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesSearchSearchCategoryMod.SearchCategoryProps])(children: _*)
  }
}
