package typings.semanticUiReact.elementsListListMod

import typings.react.reactMod.FunctionComponent
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.elementsListListContentMod.ListContentProps
import typings.semanticUiReact.elementsListListDescriptionMod.ListDescriptionProps
import typings.semanticUiReact.elementsListListHeaderMod.ListHeaderProps
import typings.semanticUiReact.elementsListListIconMod.ListIconProps
import typings.semanticUiReact.elementsListListItemMod.ListItemProps
import typings.semanticUiReact.elementsListListListMod.ListListProps
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

