package typings.vfile

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait VFileOptions extends StObject {
  
  var contents: js.UndefOr[VFileContents] = js.native
}
object VFileOptions {
  
  @scala.inline
  def apply(): VFileOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[VFileOptions]
  }
  
  @scala.inline
  implicit class VFileOptionsMutableBuilder[Self <: VFileOptions] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setContents(value: VFileContents): Self = StObject.set(x, "contents", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setContentsUndefined: Self = StObject.set(x, "contents", js.undefined)
  }
}
