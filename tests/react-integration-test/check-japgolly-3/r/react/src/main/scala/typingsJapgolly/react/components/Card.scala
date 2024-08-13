package typingsJapgolly.react.components

import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.componentstestMod.CardGridProps
import typingsJapgolly.react.componentstestMod.CardProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Card {
  
  object Grid2 {
    
    @JSImport("react/componentstest", "Card.Grid2")
    @js.native
    val component: js.Object = js.native
    
    type Props = CardGridProps
    
    implicit def make(companion: Grid2.type): SharedBuilder_CardGridProps_674843820 = new SharedBuilder_CardGridProps_674843820(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: CardGridProps): SharedBuilder_CardGridProps_674843820 = new SharedBuilder_CardGridProps_674843820(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("react/componentstest", "Card")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    
    inline def prefixCls(value: String): this.type = set("prefixCls", value.asInstanceOf[js.Any])
  }
  
  type Props = CardProps
  
  implicit def make(companion: Card.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: CardProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
