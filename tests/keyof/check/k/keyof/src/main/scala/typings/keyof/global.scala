package typings.keyof

import typings.keyof.keyofStrings.b
import typings.keyof.keyofStrings.c
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSGlobalScope
@js.native
object global extends js.Object {
  
  @js.native
  class B ()
    extends typings.keyof.B
  
  @js.native
  object C extends js.Object {
    
    def bar(p: /* keyof keyof.anon.PickAcb */ c | b): String = js.native
  }
}
