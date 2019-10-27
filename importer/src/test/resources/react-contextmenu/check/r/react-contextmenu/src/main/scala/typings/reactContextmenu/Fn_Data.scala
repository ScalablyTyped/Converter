package typings.reactContextmenu

import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.std.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Fn_Data extends js.Object {
  def apply(
    event: MouseEvent[HTMLElement, NativeMouseEvent],
    data: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any,
    target: HTMLElement
  ): Unit = js.native
}

