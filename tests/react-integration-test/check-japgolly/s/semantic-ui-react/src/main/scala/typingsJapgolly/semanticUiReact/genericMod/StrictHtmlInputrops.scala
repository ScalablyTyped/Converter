package typingsJapgolly.semanticUiReact.genericMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait StrictHtmlInputrops extends js.Object {
  
  var `type`: js.UndefOr[String] = js.native
}
object StrictHtmlInputrops {
  
  @scala.inline
  def apply(): StrictHtmlInputrops = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictHtmlInputrops]
  }
  
  @scala.inline
  implicit class StrictHtmlInputropsOps[Self <: StrictHtmlInputrops] (val x: Self) extends AnyVal {
    
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
    def setType(value: String): Self = this.set("type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteType: Self = this.set("type", js.undefined)
  }
}
