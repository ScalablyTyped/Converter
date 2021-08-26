package typings.serveStatic

import typings.expressServeStaticCore.mod.Handler
import typings.expressServeStaticCore.mod.Response
import typings.mime.mod.TypeMap
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  inline def apply(root: String): Handler = ^.asInstanceOf[js.Dynamic].apply(root.asInstanceOf[js.Any]).asInstanceOf[Handler]
  inline def apply(root: String, options: ServeStaticOptions): Handler = (^.asInstanceOf[js.Dynamic].apply(root.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Handler]
  
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
    
    inline def define(mimes: TypeMap): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("define")(mimes.asInstanceOf[js.Any]).asInstanceOf[Unit]
    inline def define(mimes: TypeMap, force: Boolean): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("define")(mimes.asInstanceOf[js.Any], force.asInstanceOf[js.Any])).asInstanceOf[Unit]
    
    inline def getExtension(mime: String): String | Null = ^.asInstanceOf[js.Dynamic].applyDynamic("getExtension")(mime.asInstanceOf[js.Any]).asInstanceOf[String | Null]
    
    inline def getType(path: String): String | Null = ^.asInstanceOf[js.Dynamic].applyDynamic("getType")(path.asInstanceOf[js.Any]).asInstanceOf[String | Null]
  }
  
  inline def serveStatic(root: String): Handler = ^.asInstanceOf[js.Dynamic].applyDynamic("serveStatic")(root.asInstanceOf[js.Any]).asInstanceOf[Handler]
  inline def serveStatic(root: String, options: ServeStaticOptions): Handler = (^.asInstanceOf[js.Dynamic].applyDynamic("serveStatic")(root.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Handler]
  
  trait ServeStaticOptions extends StObject {
    
    var setHeaders: js.UndefOr[js.Function3[/* res */ Response, /* path */ String, /* stat */ js.Any, js.Any]] = js.undefined
  }
  object ServeStaticOptions {
    
    inline def apply(): ServeStaticOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ServeStaticOptions]
    }
    
    extension [Self <: ServeStaticOptions](x: Self) {
      
      inline def setSetHeaders(value: (/* res */ Response, /* path */ String, /* stat */ js.Any) => js.Any): Self = StObject.set(x, "setHeaders", js.Any.fromFunction3(value))
      
      inline def setSetHeadersUndefined: Self = StObject.set(x, "setHeaders", js.undefined)
    }
  }
}
