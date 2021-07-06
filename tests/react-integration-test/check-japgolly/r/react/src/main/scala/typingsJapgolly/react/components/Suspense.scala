package typingsJapgolly.react.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.mod.SuspenseProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Suspense {
  
  @JSImport("react", "Suspense")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    
    @scala.inline
    def fallback(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any
    ): this.type = set("fallback", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fallbackNull: this.type = set("fallback", null)
  }
  
  implicit def make(companion: Suspense.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: SuspenseProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
