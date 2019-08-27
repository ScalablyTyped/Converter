package typings.swiz.swizMod

import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ISwizOptions extends js.Object {
  var `for`: UndefOr[String] = js.undefined
  var stripNulls: UndefOr[Boolean] = js.undefined
  var stripSerializerType: UndefOr[Boolean] = js.undefined
}

object ISwizOptions {
  @scala.inline
  def apply(
    `for`: String = null,
    stripNulls: `<undefined>` | Boolean = js.undefined,
    stripSerializerType: `<undefined>` | Boolean = js.undefined
  ): ISwizOptions = {
    val __obj = js.Dynamic.literal()
    if (`for` != null) __obj.updateDynamic("for")(`for`)
    if (!js.isUndefined(stripNulls)) __obj.updateDynamic("stripNulls")(stripNulls)
    if (!js.isUndefined(stripSerializerType)) __obj.updateDynamic("stripSerializerType")(stripSerializerType)
    __obj.asInstanceOf[ISwizOptions]
  }
}

