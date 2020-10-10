package typings.expressServeStaticCore

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object mod {
  
  type Handler = typings.expressServeStaticCore.mod.RequestHandler
  
  type NextFunction = js.Function1[/* err */ js.UndefOr[js.Any], scala.Unit]
  
  type RequestHandler = js.Function3[
    /* req */ typings.expressServeStaticCore.mod.Request, 
    /* res */ typings.expressServeStaticCore.mod.Response, 
    /* next */ typings.expressServeStaticCore.mod.NextFunction, 
    js.Any
  ]
}
