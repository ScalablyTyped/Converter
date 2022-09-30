package typings.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait TemplateStringsArray
  extends StObject
     with ReadonlyArray[String] {
  
  val raw: js.Array[String]
}
object TemplateStringsArray {
  
  inline def apply(raw: js.Array[String]): TemplateStringsArray = {
    val __obj = js.Dynamic.literal(raw = raw.asInstanceOf[js.Any])
    __obj.asInstanceOf[TemplateStringsArray]
  }
  
  extension [Self <: TemplateStringsArray](x: Self) {
    
    inline def setRaw(value: js.Array[String]): Self = StObject.set(x, "raw", value.asInstanceOf[js.Any])
    
    inline def setRawVarargs(value: String*): Self = StObject.set(x, "raw", js.Array(value*))
  }
}
