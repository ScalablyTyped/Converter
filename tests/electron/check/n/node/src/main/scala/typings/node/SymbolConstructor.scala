package typings.node

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait SymbolConstructor extends StObject {
  
  val asyncIterator: js.Symbol
  
  val iterator: js.Symbol
}
object SymbolConstructor {
  
  inline def apply(asyncIterator: js.Symbol, iterator: js.Symbol): SymbolConstructor = {
    val __obj = js.Dynamic.literal(asyncIterator = asyncIterator.asInstanceOf[js.Any], iterator = iterator.asInstanceOf[js.Any])
    __obj.asInstanceOf[SymbolConstructor]
  }
  
  extension [Self <: SymbolConstructor](x: Self) {
    
    inline def setAsyncIterator(value: js.Symbol): Self = StObject.set(x, "asyncIterator", value.asInstanceOf[js.Any])
    
    inline def setIterator(value: js.Symbol): Self = StObject.set(x, "iterator", value.asInstanceOf[js.Any])
  }
}
