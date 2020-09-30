package typings.fpTs.constMod.fpTsLibHKTAugmentingMod

import typings.fpTs.constMod.Const
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait URI2HKT2[L, A] extends js.Object {
  var Const: typings.fpTs.constMod.Const[L, A] = js.native
}

object URI2HKT2 {
  @scala.inline
  def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
    val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
    __obj.asInstanceOf[URI2HKT2[L, A]]
  }
  @scala.inline
  implicit class URI2HKT2Ops[Self <: URI2HKT2[_, _], L, A] (val x: Self with (URI2HKT2[L, A])) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setConst(value: Const[L, A]): Self = this.set("Const", value.asInstanceOf[js.Any])
  }
  
}

