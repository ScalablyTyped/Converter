package typings.expressServeStaticCore

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait Request
    extends typings.expressServeStaticCore.mod.global.Express.Request {
    
    var url: String = js.native
  }
  object Request {
    
    @scala.inline
    def apply(url: String): Request = {
      val __obj = js.Dynamic.literal(url = url.asInstanceOf[js.Any])
      __obj.asInstanceOf[Request]
    }
    
    @scala.inline
    implicit class RequestOps[Self <: Request] (val x: Self) extends AnyVal {
      
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
      def setUrl(value: String): Self = this.set("url", value.asInstanceOf[js.Any])
    }
  }
  
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
  
  object global {
    
    object Express {
      
      @js.native
      trait Application extends js.Object
      
      // These open interfaces may be extended in an application-specific manner via declaration merging.
      // See for example method-override.d.ts (https://github.com/DefinitelyTyped/DefinitelyTyped/blob/master/types/method-override/index.d.ts)
      @js.native
      trait Request extends js.Object
      
      @js.native
      trait Response extends js.Object
    }
  }
  
  type Handler = RequestHandler
  
  type NextFunction = js.Function1[/* err */ js.UndefOr[js.Any], Unit]
  
  type RequestHandler = js.Function3[/* req */ Request, /* res */ Response, /* next */ NextFunction, js.Any]
}
