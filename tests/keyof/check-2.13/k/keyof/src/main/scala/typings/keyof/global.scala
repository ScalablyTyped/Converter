package typings.keyof

import typings.keyof.keyofStrings.b
import typings.keyof.keyofStrings.c
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @JSGlobal("B")
  @js.native
  class B ()
    extends StObject
       with typings.keyof.B
  
  object C {
    
    @JSGlobal("C")
    @js.native
    val ^ : js.Any = js.native
    
    @scala.inline
    def bar(p: /* keyof keyof.anon.PickAcb */ c | b): String = ^.asInstanceOf[js.Dynamic].applyDynamic("bar")(p.asInstanceOf[js.Any]).asInstanceOf[String]
  }
}
