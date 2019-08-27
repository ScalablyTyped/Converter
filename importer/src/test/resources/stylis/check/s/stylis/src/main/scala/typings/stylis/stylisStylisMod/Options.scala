package typings.stylis.stylisStylisMod

import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Options extends js.Object {
  var cascade: UndefOr[Boolean] = js.undefined
  var compress: UndefOr[Boolean] = js.undefined
  var global: UndefOr[Boolean] = js.undefined
  var keyframe: UndefOr[Boolean] = js.undefined
  var prefix: UndefOr[
    Boolean | (js.Function3[/* key */ String, /* value */ String, /* context */ Double, Boolean])
  ] = js.undefined
  var preserve: UndefOr[Boolean] = js.undefined
  var semicolon: UndefOr[Boolean] = js.undefined
}

object Options {
  @scala.inline
  def apply(
    cascade: `<undefined>` | Boolean = js.undefined,
    compress: `<undefined>` | Boolean = js.undefined,
    global: `<undefined>` | Boolean = js.undefined,
    keyframe: `<undefined>` | Boolean = js.undefined,
    prefix: Boolean | (js.Function3[/* key */ String, /* value */ String, /* context */ Double, Boolean]) = null,
    preserve: `<undefined>` | Boolean = js.undefined,
    semicolon: `<undefined>` | Boolean = js.undefined
  ): Options = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(cascade)) __obj.updateDynamic("cascade")(cascade)
    if (!js.isUndefined(compress)) __obj.updateDynamic("compress")(compress)
    if (!js.isUndefined(global)) __obj.updateDynamic("global")(global)
    if (!js.isUndefined(keyframe)) __obj.updateDynamic("keyframe")(keyframe)
    if (prefix != null) __obj.updateDynamic("prefix")(prefix.asInstanceOf[js.Any])
    if (!js.isUndefined(preserve)) __obj.updateDynamic("preserve")(preserve)
    if (!js.isUndefined(semicolon)) __obj.updateDynamic("semicolon")(semicolon)
    __obj.asInstanceOf[Options]
  }
}

