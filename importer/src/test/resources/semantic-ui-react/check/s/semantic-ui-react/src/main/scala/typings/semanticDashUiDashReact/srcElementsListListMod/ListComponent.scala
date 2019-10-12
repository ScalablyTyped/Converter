package typings.semanticDashUiDashReact.srcElementsListListMod

import typings.react.reactMod.FunctionComponent
import typings.react.reactMod.StatelessComponent
import typings.semanticDashUiDashReact.srcElementsListListContentMod.ListContentProps
import typings.semanticDashUiDashReact.srcElementsListListDescriptionMod.ListDescriptionProps
import typings.semanticDashUiDashReact.srcElementsListListHeaderMod.ListHeaderProps
import typings.semanticDashUiDashReact.srcElementsListListIconMod.ListIconProps
import typings.semanticDashUiDashReact.srcElementsListListItemMod.ListItemProps
import typings.semanticDashUiDashReact.srcElementsListListListMod.ListListProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ListComponent extends FunctionComponent[ListProps] {
  var Content: StatelessComponent[ListContentProps] = js.native
  var Description: StatelessComponent[ListDescriptionProps] = js.native
  var Header: StatelessComponent[ListHeaderProps] = js.native
  var Icon: StatelessComponent[ListIconProps] = js.native
  var Item: StatelessComponent[ListItemProps] = js.native
  var List: StatelessComponent[ListListProps] = js.native
}

