package typings.node.NodeJS

import typings.std.ArrayConstrucor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Global extends js.Object {
  
  var Array: ArrayConstrucor = js.native
  
  var global: Global = js.native
}
object Global {
  
  @scala.inline
  def apply(Array: ArrayConstrucor, global: Global): Global = {
    val __obj = js.Dynamic.literal(Array = Array.asInstanceOf[js.Any], global = global.asInstanceOf[js.Any])
    __obj.asInstanceOf[Global]
  }
  
  @scala.inline
  implicit class GlobalOps[Self <: Global] (val x: Self) extends AnyVal {
    
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
    def setArray(value: ArrayConstrucor): Self = this.set("Array", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setGlobal(value: Global): Self = this.set("global", value.asInstanceOf[js.Any])
  }
}
