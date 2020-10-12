package typings.fpTs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object constMod {
  
  @JSImport("fp-ts/lib/Const", "URI")
  @js.native
  val URI: /* "Const" */ String = js.native
  
  @JSImport("fp-ts/lib/Const", "Const")
  @js.native
  class Const[L, A] protected () extends js.Object {
    def this(value: L) = this()
    
    val _A: A = js.native
    
    val _L: L = js.native
    
    val _URI: typings.fpTs.constMod.URI = js.native
    
    def contramap[B](f: js.Function1[/* b */ B, A]): Const[L, B] = js.native
    
    def fold[B](f: js.Function1[/* l */ L, B]): B = js.native
    
    def inspect(): String = js.native
    
    def map[B](f: js.Function1[/* a */ A, B]): Const[L, B] = js.native
    
    val value: L = js.native
  }
  
  /* augmented module */
  object fpTsLibHKTAugmentingMod {
    
    @js.native
    trait URI2HKT2[L, A] extends js.Object {
      
      var Const: typings.fpTs.constMod.Const[L, A] = js.native
    }
    object URI2HKT2 {
      
      @scala.inline
      def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
        val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
        __obj.asInstanceOf[URI2HKT2[L, A]]
      }
      
      @scala.inline
      implicit class URI2HKT2Ops[Self <: URI2HKT2[_, _], L, A] (val x: Self with (URI2HKT2[L, A])) extends AnyVal {
        
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
        def setConst(value: Const[L, A]): Self = this.set("Const", value.asInstanceOf[js.Any])
      }
    }
  }
  
  type URI = /* "Const" */ String
}
