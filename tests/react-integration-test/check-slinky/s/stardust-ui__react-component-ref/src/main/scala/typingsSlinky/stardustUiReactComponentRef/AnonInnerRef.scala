package typingsSlinky.stardustUiReactComponentRef

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonInnerRef extends js.Object {
  var children: js.UndefOr[scala.Nothing] = js.native
  var innerRef: js.UndefOr[scala.Nothing] = js.native
}

object AnonInnerRef {
  @scala.inline
  def apply(
    children: js.UndefOr[scala.Nothing] = js.undefined,
    innerRef: js.UndefOr[scala.Nothing] = js.undefined
  ): AnonInnerRef = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(children)) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (!js.isUndefined(innerRef)) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonInnerRef]
  }
}

