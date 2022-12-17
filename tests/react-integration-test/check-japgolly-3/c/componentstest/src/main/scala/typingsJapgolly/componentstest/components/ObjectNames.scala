package typingsJapgolly.componentstest.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.componentstest.anon.Equals
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ObjectNames {
  
  inline def apply(finalize_ : js.Object => Boolean): Builder = {
    val __props = js.Dynamic.literal()
    __props.updateDynamic("finalize")(js.Any.fromFunction1(finalize_))
    new Builder(js.Array(this.component, __props.asInstanceOf[Equals]))
  }
  
  @JSImport("componentstest", "ObjectNames")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    
    inline def equals_(value: Boolean): this.type = set("equals", value.asInstanceOf[js.Any])
    
    inline def ne_(value: /* other */ js.Object => Boolean): this.type = set("ne", js.Any.fromFunction1(value))
  }
  
  type Props = Equals
  
  def withProps(p: Equals): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
