package typings.keyof

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @JSGlobal("B")
  @js.native
  class B ()
    extends StObject
       with typings.keyof.B {
    
    /* CompleteClass */
    override def foo2[T](p: /* keyof T */ String): String = js.native
    
    /* CompleteClass */
    @JSName("foo")
    override def foo_a(p: "a" | "b" | "c"): String = js.native
  }
  
  object C {
    
    @JSGlobal("C")
    @js.native
    val ^ : js.Any = js.native
    
    inline def bar(p: /* keyof keyof.anon.PickAcb */ "c" | "b"): String = ^.asInstanceOf[js.Dynamic].applyDynamic("bar")(p.asInstanceOf[js.Any]).asInstanceOf[String]
  }
}
