package typings.node

import typings.node.anon.TypeofimportedHttp2
import typings.node.anon.TypeofimportedOs
import typings.node.nodeStrings.http2
import typings.node.nodeStrings.os
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object processMod {
  
  object global {
    
    object NodeJS {
      
      @js.native
      trait Process extends StObject {
        
        @JSName("getBuiltinModule")
        def getBuiltinModule_http2(id: http2): TypeofimportedHttp2 = js.native
        @JSName("getBuiltinModule")
        def getBuiltinModule_os(id: os): TypeofimportedOs = js.native
      }
    }
  }
}
