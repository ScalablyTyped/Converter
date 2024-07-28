package typings.stripeJs

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait AdvancedFraudSignals extends StObject {
    
    var advancedFraudSignals: Boolean
  }
  object AdvancedFraudSignals {
    
    inline def apply(advancedFraudSignals: Boolean): AdvancedFraudSignals = {
      val __obj = js.Dynamic.literal(advancedFraudSignals = advancedFraudSignals.asInstanceOf[js.Any])
      __obj.asInstanceOf[AdvancedFraudSignals]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: AdvancedFraudSignals] (val x: Self) extends AnyVal {
      
      inline def setAdvancedFraudSignals(value: Boolean): Self = StObject.set(x, "advancedFraudSignals", value.asInstanceOf[js.Any])
    }
  }
  
  trait SetLoadParameters extends StObject {
    
    def setLoadParameters(params: AdvancedFraudSignals): Unit
  }
  object SetLoadParameters {
    
    inline def apply(setLoadParameters: AdvancedFraudSignals => Unit): SetLoadParameters = {
      val __obj = js.Dynamic.literal(setLoadParameters = js.Any.fromFunction1(setLoadParameters))
      __obj.asInstanceOf[SetLoadParameters]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: SetLoadParameters] (val x: Self) extends AnyVal {
      
      inline def setSetLoadParameters(value: AdvancedFraudSignals => Unit): Self = StObject.set(x, "setLoadParameters", js.Any.fromFunction1(value))
    }
  }
}
