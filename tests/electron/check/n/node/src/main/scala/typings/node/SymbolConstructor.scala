package typings.node

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait SymbolConstructor extends StObject {
  
  val asyncIterator: js.Symbol = js.native
  
  val iterator: js.Symbol = js.native
}
object SymbolConstructor {
  
  @scala.inline
  def apply(asyncIterator: js.Symbol, iterator: js.Symbol): SymbolConstructor = {
    val __obj = js.Dynamic.literal(asyncIterator = asyncIterator.asInstanceOf[js.Any], iterator = iterator.asInstanceOf[js.Any])
    __obj.asInstanceOf[SymbolConstructor]
  }
  
  @scala.inline
  implicit class SymbolConstructorMutableBuilder[Self <: SymbolConstructor] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAsyncIterator(value: js.Symbol): Self = StObject.set(x, "asyncIterator", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setIterator(value: js.Symbol): Self = StObject.set(x, "iterator", value.asInstanceOf[js.Any])
  }
}
