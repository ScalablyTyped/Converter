package typings.bigint

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Test extends StObject {
  
  var a: js.BigInt = js.native
  
  var b: js.BigInt = js.native
  
  var c: typings.bigint.BigInt.BigInt = js.native
}
object Test {
  
  @scala.inline
  def apply(a: js.BigInt, b: js.BigInt, c: typings.bigint.BigInt.BigInt): Test = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
    __obj.asInstanceOf[Test]
  }
  
  @scala.inline
  implicit class TestMutableBuilder[Self <: Test] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setA(value: js.BigInt): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setB(value: js.BigInt): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setC(value: typings.bigint.BigInt.BigInt): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setCVarargs(value: Double*): Self = StObject.set(x, "c", js.Array(value :_*))
  }
}
