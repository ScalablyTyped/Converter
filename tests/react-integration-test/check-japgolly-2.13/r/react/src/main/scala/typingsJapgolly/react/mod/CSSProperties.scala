package typingsJapgolly.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* import warning: RemoveDifficultInheritance.summarizeChanges 
- Dropped / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify CSS.Properties<string | number> * / any */ @js.native
trait CSSProperties extends StObject {
  
  /* fake member to keep old syntax */
  val hack: js.UndefOr[js.Any] = js.native
}
object CSSProperties {
  
  @scala.inline
  def apply(): CSSProperties = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[CSSProperties]
  }
  
  @scala.inline
  implicit class CSSPropertiesMutableBuilder[Self <: CSSProperties] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setHack(value: js.Any): Self = StObject.set(x, "hack", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setHackUndefined: Self = StObject.set(x, "hack", js.undefined)
  }
}
