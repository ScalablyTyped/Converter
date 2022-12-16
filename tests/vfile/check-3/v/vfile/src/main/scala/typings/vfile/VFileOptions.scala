package typings.vfile

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait VFileOptions extends StObject {
  
  var contents: js.UndefOr[VFileContents] = js.undefined
}
object VFileOptions {
  
  inline def apply(): VFileOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[VFileOptions]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: VFileOptions] (val x: Self) extends AnyVal {
    
    inline def setContents(value: VFileContents): Self = StObject.set(x, "contents", value.asInstanceOf[js.Any])
    
    inline def setContentsUndefined: Self = StObject.set(x, "contents", js.undefined)
  }
}
