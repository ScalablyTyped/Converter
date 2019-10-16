package typings.semanticUiReact.modulesSearchSearchMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.modulesSearchSearchCategoryMod.SearchCategoryProps
import typings.semanticUiReact.modulesSearchSearchResultMod.SearchResultProps
import typings.semanticUiReact.modulesSearchSearchResultsMod.SearchResultsProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SearchComponent extends ComponentClass[SearchProps, ComponentState] {
  var Category: StatelessComponent[SearchCategoryProps] = js.native
  var Result: ComponentClass[SearchResultProps, ComponentState] = js.native
  var Results: StatelessComponent[SearchResultsProps] = js.native
}

