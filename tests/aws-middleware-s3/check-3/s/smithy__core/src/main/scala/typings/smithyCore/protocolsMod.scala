package typings.smithyCore

import typings.smithyTypes.mod.ClientProtocol
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object protocolsMod {
  
  /* note: abstract class */ @JSImport("@smithy/core/protocols", "HttpProtocol")
  @js.native
  open class HttpProtocol ()
    extends StObject
       with ClientProtocol {
    
    /* CompleteClass */
    override def serializeRequest(): js.Promise[Any] = js.native
  }
}
