package typings.expressServeStaticCore

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  type Handler = RequestHandler
  
  type NextFunction = js.Function1[/* err */ js.UndefOr[js.Any], Unit]
  
  trait Request
    extends StObject
       with typings.expressServeStaticCore.mod.global.Express.Request {
    
    var url: String
  }
  object Request {
    
    inline def apply(url: String): Request = {
      val __obj = js.Dynamic.literal(url = url.asInstanceOf[js.Any])
      __obj.asInstanceOf[Request]
    }
    
    extension [Self <: Request](x: Self) {
      
      inline def setUrl(value: String): Self = StObject.set(x, "url", value.asInstanceOf[js.Any])
    }
  }
  
  type RequestHandler = js.Function3[/* req */ Request, /* res */ Response, /* next */ NextFunction, js.Any]
  
  trait Response
    extends StObject
       with typings.expressServeStaticCore.mod.global.Express.Response {
    
    def location(url: String): Response
  }
  object Response {
    
    inline def apply(location: String => Response): Response = {
      val __obj = js.Dynamic.literal(location = js.Any.fromFunction1(location))
      __obj.asInstanceOf[Response]
    }
    
    extension [Self <: Response](x: Self) {
      
      inline def setLocation(value: String => Response): Self = StObject.set(x, "location", js.Any.fromFunction1(value))
    }
  }
  
  object global {
    
    object Express {
      
      trait Application extends StObject
      
      // These open interfaces may be extended in an application-specific manner via declaration merging.
      // See for example method-override.d.ts (https://github.com/DefinitelyTyped/DefinitelyTyped/blob/master/types/method-override/index.d.ts)
      trait Request extends StObject
      
      trait Response extends StObject
    }
  }
}
