package typings.expandTypeParameters

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait C extends StObject {
  
  var c: js.UndefOr[Double] = js.native
}
object C {
  
  @scala.inline
  def apply(): C = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[C]
  }
  
  @scala.inline
  implicit class CMutableBuilder[Self <: C] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setC(value: Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setCUndefined: Self = StObject.set(x, "c", js.undefined)
  }
}
