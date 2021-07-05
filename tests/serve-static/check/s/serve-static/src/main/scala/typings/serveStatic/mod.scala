package typings.serveStatic

import typings.expressServeStaticCore.mod.Handler
import typings.expressServeStaticCore.mod.Response
import typings.mime.mod.TypeMap
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @scala.inline
  def apply(root: String): Handler = ^.asInstanceOf[js.Dynamic].apply(root.asInstanceOf[js.Any]).asInstanceOf[Handler]
  @scala.inline
  def apply(root: String, options: ServeStaticOptions): Handler = (^.asInstanceOf[js.Dynamic].apply(root.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Handler]
  
  @JSImport("serve-static", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  object mime {
    
    @JSImport("serve-static", "mime")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("serve-static", "mime.default_type")
    @js.native
    val defaultType: String = js.native
    
    @scala.inline
    def define(mimes: TypeMap): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("define")(mimes.asInstanceOf[js.Any]).asInstanceOf[Unit]
    @scala.inline
    def define(mimes: TypeMap, force: Boolean): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("define")(mimes.asInstanceOf[js.Any], force.asInstanceOf[js.Any])).asInstanceOf[Unit]
    
    @scala.inline
    def getExtension(mime: String): String | Null = ^.asInstanceOf[js.Dynamic].applyDynamic("getExtension")(mime.asInstanceOf[js.Any]).asInstanceOf[String | Null]
    
    @scala.inline
    def getType(path: String): String | Null = ^.asInstanceOf[js.Dynamic].applyDynamic("getType")(path.asInstanceOf[js.Any]).asInstanceOf[String | Null]
  }
  
  @scala.inline
  def serveStatic(root: String): Handler = ^.asInstanceOf[js.Dynamic].applyDynamic("serveStatic")(root.asInstanceOf[js.Any]).asInstanceOf[Handler]
  @scala.inline
  def serveStatic(root: String, options: ServeStaticOptions): Handler = (^.asInstanceOf[js.Dynamic].applyDynamic("serveStatic")(root.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Handler]
  
  @js.native
  trait ServeStaticOptions extends StObject {
    
    var setHeaders: js.UndefOr[js.Function3[/* res */ Response, /* path */ String, /* stat */ js.Any, js.Any]] = js.native
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
      def setSetHeaders(value: (/* res */ Response, /* path */ String, /* stat */ js.Any) => js.Any): Self = StObject.set(x, "setHeaders", js.Any.fromFunction3(value))
      
      @scala.inline
      def setSetHeadersUndefined: Self = StObject.set(x, "setHeaders", js.undefined)
    }
  }
}
