package typings.reactContextmenu.mod

import typings.react.mod.HTMLAttributes
import typings.react.mod.ReactType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ContextMenuTriggerProps extends js.Object {
  var attributes: js.UndefOr[HTMLAttributes[_]] = js.undefined
  var collect: js.UndefOr[js.Function1[/* data */ js.Any, _]] = js.undefined
  var disable: js.UndefOr[Boolean] = js.undefined
  var holdToDisplay: js.UndefOr[Double] = js.undefined
  var id: String
  var renderTag: js.UndefOr[ReactType[_]] = js.undefined
}

object ContextMenuTriggerProps {
  @scala.inline
  def apply(
    id: String,
    attributes: HTMLAttributes[_] = null,
    collect: /* data */ js.Any => _ = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactType[_] = null
  ): ContextMenuTriggerProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    if (attributes != null) __obj.updateDynamic("attributes")(attributes.asInstanceOf[js.Any])
    if (collect != null) __obj.updateDynamic("collect")(js.Any.fromFunction1(collect))
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable.asInstanceOf[js.Any])
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuTriggerProps]
  }
}

