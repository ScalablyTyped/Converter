package typings.reactDashContextmenu.reactDashContextmenuMod

import japgolly.scalajs.react.CallbackTo
import typings.react.reactMod.HTMLAttributes
import typings.react.reactMod.ReactType
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
    collect: /* data */ js.Any => CallbackTo[_] = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactType[_] = null
  ): ContextMenuTriggerProps = {
    val __obj = js.Dynamic.literal(id = id)
    if (attributes != null) __obj.updateDynamic("attributes")(attributes)
    if (collect != null) __obj.updateDynamic("collect")(js.Any.fromFunction1((t0: /* data */ js.Any) => collect(t0).runNow()))
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable)
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuTriggerProps]
  }
}

