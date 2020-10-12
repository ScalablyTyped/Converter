package typingsJapgolly.componentstest

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Equals extends js.Object {
    
    @JSName("equals")
    var equals_FEquals: js.UndefOr[Boolean] = js.native
    
    def finalize(other: js.Object): Boolean = js.native
    
    @JSName("ne")
    var ne_FEquals: js.UndefOr[js.Function1[/* other */ js.Object, Boolean]] = js.native
  }
  object Equals {
    
    @scala.inline
    def apply(finalize_ : js.Object => Boolean): Equals = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("finalize")(js.Any.fromFunction1(finalize_))
      __obj.asInstanceOf[Equals]
    }
    
    @scala.inline
    implicit class EqualsOps[Self <: Equals] (val x: Self) extends AnyVal {
      
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
      def setFinalize_(value: js.Object => Boolean): Self = this.set("finalize", js.Any.fromFunction1(value))
      
      @scala.inline
      def setEquals_(value: Boolean): Self = this.set("equals", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteEquals_ : Self = this.set("equals", js.undefined)
      
      @scala.inline
      def setNe_(value: /* other */ js.Object => Boolean): Self = this.set("ne", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteNe_ : Self = this.set("ne", js.undefined)
    }
  }
}
