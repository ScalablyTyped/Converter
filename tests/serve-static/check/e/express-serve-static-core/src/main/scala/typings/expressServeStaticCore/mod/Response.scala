package typings.expressServeStaticCore.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Response
  extends typings.expressServeStaticCore.mod.global.Express.Response {
  
  def location(url: String): Response = js.native
}
object Response {
  
  @scala.inline
  def apply(location: String => Response): Response = {
    val __obj = js.Dynamic.literal(location = js.Any.fromFunction1(location))
    __obj.asInstanceOf[Response]
  }
  
  @scala.inline
  implicit class ResponseOps[Self <: Response] (val x: Self) extends AnyVal {
    
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
    def setLocation(value: String => Response): Self = this.set("location", js.Any.fromFunction1(value))
  }
}
