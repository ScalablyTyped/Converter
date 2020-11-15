package typings.fpTs.hktMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait HKT[URI, A] extends js.Object {
  
  val _A: A = js.native
  
  val _URI: URI = js.native
}
object HKT {
  
  @scala.inline
  def apply[URI, A](_A: A, _URI: URI): HKT[URI, A] = {
    val __obj = js.Dynamic.literal(_A = _A.asInstanceOf[js.Any], _URI = _URI.asInstanceOf[js.Any])
    __obj.asInstanceOf[HKT[URI, A]]
  }
  
  @scala.inline
  implicit class HKTOps[Self <: HKT[_, _], URI, A] (val x: Self with (HKT[URI, A])) extends AnyVal {
    
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
    def set_A(value: A): Self = this.set("_A", value.asInstanceOf[js.Any])
    
    @scala.inline
    def set_URI(value: URI): Self = this.set("_URI", value.asInstanceOf[js.Any])
  }
}
