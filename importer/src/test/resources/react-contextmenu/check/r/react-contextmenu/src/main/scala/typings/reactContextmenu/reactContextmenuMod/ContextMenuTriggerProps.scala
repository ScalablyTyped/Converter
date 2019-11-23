package typings.reactContextmenu.reactContextmenuMod

import typings.react.reactMod.HTMLAttributes
import typings.react.reactMod.ReactType
import typings.reactContextmenu.Fn_DataAny
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ContextMenuTriggerProps extends js.Object {
  var attributes: js.UndefOr[HTMLAttributes[_]] = js.undefined
  var collect: js.UndefOr[Fn_DataAny] = js.undefined
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
    collect: Fn_DataAny = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactType[_] = null
  ): ContextMenuTriggerProps = {
    val __obj = js.Dynamic.literal(id = id)
    if (attributes != null) __obj.updateDynamic("attributes")(attributes)
    if (collect != null) __obj.updateDynamic("collect")(collect)
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable)
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuTriggerProps]
  }
}

