package typings.keyof

import typings.keyof.keyofStrings.b
import typings.keyof.keyofStrings.c
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @JSGlobal("B")
  @js.native
  class B ()
    extends typings.keyof.B
  
  object C {
    
    @JSGlobal("C.bar")
    @js.native
    def bar(p: /* keyof keyof.anon.PickAcb */ c | b): String = js.native
  }
}
