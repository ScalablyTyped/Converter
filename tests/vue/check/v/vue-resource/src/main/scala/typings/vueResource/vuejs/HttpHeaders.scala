package typings.vueResource.vuejs

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait HttpHeaders
  extends /* key */ StringDictionary[js.Any] {
  
  var common: js.UndefOr[StringDictionary[String]] = js.native
  
  var custom: js.UndefOr[StringDictionary[String]] = js.native
  
  var delete: js.UndefOr[StringDictionary[String]] = js.native
  
  var patch: js.UndefOr[StringDictionary[String]] = js.native
  
  var post: js.UndefOr[StringDictionary[String]] = js.native
  
  var put: js.UndefOr[StringDictionary[String]] = js.native
}
object HttpHeaders {
  
  @scala.inline
  def apply(): HttpHeaders = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[HttpHeaders]
  }
  
  @scala.inline
  implicit class HttpHeadersOps[Self <: HttpHeaders] (val x: Self) extends AnyVal {
    
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
    def setCommon(value: StringDictionary[String]): Self = this.set("common", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteCommon: Self = this.set("common", js.undefined)
    
    @scala.inline
    def setCustom(value: StringDictionary[String]): Self = this.set("custom", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteCustom: Self = this.set("custom", js.undefined)
    
    @scala.inline
    def setDelete(value: StringDictionary[String]): Self = this.set("delete", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteDelete: Self = this.set("delete", js.undefined)
    
    @scala.inline
    def setPatch(value: StringDictionary[String]): Self = this.set("patch", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deletePatch: Self = this.set("patch", js.undefined)
    
    @scala.inline
    def setPost(value: StringDictionary[String]): Self = this.set("post", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deletePost: Self = this.set("post", js.undefined)
    
    @scala.inline
    def setPut(value: StringDictionary[String]): Self = this.set("put", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deletePut: Self = this.set("put", js.undefined)
  }
}
