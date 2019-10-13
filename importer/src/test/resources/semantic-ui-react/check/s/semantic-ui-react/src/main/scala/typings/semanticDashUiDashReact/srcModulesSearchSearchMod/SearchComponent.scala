package typings.semanticDashUiDashReact.srcModulesSearchSearchMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticDashUiDashReact.srcModulesSearchSearchCategoryMod.SearchCategoryProps
import typings.semanticDashUiDashReact.srcModulesSearchSearchResultMod.SearchResultProps
import typings.semanticDashUiDashReact.srcModulesSearchSearchResultsMod.SearchResultsProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SearchComponent extends ComponentClass[SearchProps, ComponentState] {
  var Category: StatelessComponent[SearchCategoryProps] = js.native
  var Result: ComponentClass[SearchResultProps, ComponentState] = js.native
  var Results: StatelessComponent[SearchResultsProps] = js.native
}

