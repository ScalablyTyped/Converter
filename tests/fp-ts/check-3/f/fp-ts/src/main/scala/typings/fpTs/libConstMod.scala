package typings.fpTs

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libConstMod {
  
  @JSImport("fp-ts/lib/Const", "Const")
  @js.native
  open class Const[L, A] protected () extends StObject {
    def this(value: L) = this()
    
    val _A: A = js.native
    
    val _L: L = js.native
    
    val _URI: typings.fpTs.libConstMod.URI = js.native
    
    def contramap[B](f: js.Function1[/* b */ B, A]): Const[L, B] = js.native
    
    def fold[B](f: js.Function1[/* l */ L, B]): B = js.native
    
    def inspect(): String = js.native
    
    def map[B](f: js.Function1[/* a */ A, B]): Const[L, B] = js.native
    
    val value: L = js.native
  }
  
  @JSImport("fp-ts/lib/Const", "URI")
  @js.native
  val URI: /* "Const" */ String = js.native
  type URI = /* "Const" */ String
  
  /* augmented module */
  object fpTsLibHKTAugmentingMod {
    
    trait URI2HKT2[L, A] extends StObject {
      
      var Const: typings.fpTs.libConstMod.Const[L, A]
    }
    object URI2HKT2 {
      
      inline def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
        val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
        __obj.asInstanceOf[URI2HKT2[L, A]]
      }
      
      @scala.inline
      implicit open class MutableBuilder[Self <: URI2HKT2[?, ?], L, A] (val x: Self & (URI2HKT2[L, A])) extends AnyVal {
        
        inline def setConst(value: Const[L, A]): Self = StObject.set(x, "Const", value.asInstanceOf[js.Any])
      }
    }
  }
}
