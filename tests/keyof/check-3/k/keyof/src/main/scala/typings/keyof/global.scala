package typings.keyof

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @JSGlobal("B")
  @js.native
  open class B ()
    extends StObject
       with typings.keyof.B {
    
    /* CompleteClass */
    @JSName("foo")
    @scala.annotation.targetName("foo_a_b_c")
    override def foo(p: "a" | "b" | "c"): String = js.native
    
    /* CompleteClass */
    override def foo2[T](p: /* keyof T */ String): String = js.native
  }
  
  object C {
    
    @JSGlobal("C")
    @js.native
    val ^ : js.Any = js.native
    
    inline def bar(p: /* keyof keyof.anon.PickAcb */ "c" | "b"): String = ^.asInstanceOf[js.Dynamic].applyDynamic("bar")(p.asInstanceOf[js.Any]).asInstanceOf[String]
  }
}
