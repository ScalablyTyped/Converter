package typings.serveStatic

import typings.expressServeStaticCore.mod.Handler
import typings.expressServeStaticCore.mod.Response
import typings.mime.mod.TypeMap
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
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
  
  @JSImport("serve-static", "serveStatic")
  @js.native
  def serveStatic(root: String): Handler = js.native
  @JSImport("serve-static", "serveStatic")
  @js.native
  def serveStatic(root: String, options: ServeStaticOptions): Handler = js.native
  
  @JSImport("serve-static", JSImport.Namespace)
  @js.native
  def apply(root: String): Handler = js.native
  @JSImport("serve-static", JSImport.Namespace)
  @js.native
  def apply(root: String, options: ServeStaticOptions): Handler = js.native
  
  @js.native
  trait ServeStaticOptions extends StObject {
    
    var setHeaders: js.UndefOr[js.Function3[/* res */ Response, /* path */ String, /* stat */ js.Any, _]] = js.native
  }
  object ServeStaticOptions {
    
    @scala.inline
    def apply(): ServeStaticOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ServeStaticOptions]
    }
    
    @scala.inline
    implicit class ServeStaticOptionsMutableBuilder[Self <: ServeStaticOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setSetHeaders(value: (/* res */ Response, /* path */ String, /* stat */ js.Any) => _): Self = StObject.set(x, "setHeaders", js.Any.fromFunction3(value))
      
      @scala.inline
      def setSetHeadersUndefined: Self = StObject.set(x, "setHeaders", js.undefined)
    }
  }
}
