package typings.serveStatic

import typings.expressServeStaticCore.mod.Handler
import typings.expressServeStaticCore.mod.Response
import typings.mime.mod.TypeMap
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("serve-static", JSImport.Namespace)
  @js.native
  def apply(root: String): Handler = js.native
  @JSImport("serve-static", JSImport.Namespace)
  @js.native
  def apply(root: String, options: ServeStaticOptions): Handler = js.native
  
  @JSImport("serve-static", "serveStatic")
  @js.native
  def serveStatic(root: String): Handler = js.native
  @JSImport("serve-static", "serveStatic")
  @js.native
  def serveStatic(root: String, options: ServeStaticOptions): Handler = js.native
  
  @js.native
  trait ServeStaticOptions extends js.Object {
    
    var setHeaders: js.UndefOr[js.Function3[/* res */ Response, /* path */ String, /* stat */ js.Any, _]] = js.native
  }
  object ServeStaticOptions {
    
    @scala.inline
    def apply(): ServeStaticOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ServeStaticOptions]
    }
    
    @scala.inline
    implicit class ServeStaticOptionsOps[Self <: ServeStaticOptions] (val x: Self) extends AnyVal {
      
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
      def setSetHeaders(value: (/* res */ Response, /* path */ String, /* stat */ js.Any) => _): Self = this.set("setHeaders", js.Any.fromFunction3(value))
      
      @scala.inline
      def deleteSetHeaders: Self = this.set("setHeaders", js.undefined)
    }
  }
  
  object mime {
    
    @JSImport("serve-static", "mime.default_type")
    @js.native
    val defaultType: String = js.native
    
    @JSImport("serve-static", "mime.define")
    @js.native
    def define(mimes: TypeMap): Unit = js.native
    @JSImport("serve-static", "mime.define")
    @js.native
    def define(mimes: TypeMap, force: Boolean): Unit = js.native
    
    @JSImport("serve-static", "mime.getExtension")
    @js.native
    def getExtension(mime: String): String | Null = js.native
    
    @JSImport("serve-static", "mime.getType")
    @js.native
    def getType(path: String): String | Null = js.native
  }
}
