package typings.reactContextmenu

import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.TouchEvent
import typings.std.HTMLDivElement
import typings.std.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Fn_DataEvent extends js.Object {
  def apply(
    event: MouseEvent[HTMLDivElement, NativeMouseEvent],
    data: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any,
    target: HTMLElement
  ): Unit = js.native
  def apply(
    event: TouchEvent[HTMLDivElement],
    data: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any,
    target: HTMLElement
  ): Unit = js.native
}

