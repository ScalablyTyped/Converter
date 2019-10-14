package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
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
  ): UnmountedWithRoot[SearchCategoryProps, js.Object, Unit, SearchCategoryProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type SearchCategoryType = scala.scalajs.js.Object
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
        if (renderer != null) __obj.updateDynamic("renderer")(js.Any.fromFunction1(((t0: /* props */ typings.semanticDashUiDashReact.srcModulesSearchSearchCategoryMod.SearchCategoryProps) => renderer(t0).runNow())))
    if (results != null) __obj.updateDynamic("results")(results)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, SearchCategoryType](js.constructorOf[SearchCategoryType])
  
    f(props)(children: _*)
  }
  type Props = SearchCategoryProps
}

