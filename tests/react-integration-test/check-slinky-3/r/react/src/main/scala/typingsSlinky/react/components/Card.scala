package typingsSlinky.react.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.componentstestMod.CardGridProps
import typingsSlinky.react.componentstestMod.CardProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Card {
  
  object Grid2 {
    
    @JSImport("react/componentstest", "Card.Grid2")
    @js.native
    val component: js.Object = js.native
    
    type Props = CardGridProps
    
    implicit def make(companion: Grid2.type): SharedBuilder_CardGridProps_1326759902 = new SharedBuilder_CardGridProps_1326759902(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: CardGridProps): SharedBuilder_CardGridProps_1326759902 = new SharedBuilder_CardGridProps_1326759902(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("react/componentstest", "Card")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    inline def prefixCls(value: String): this.type = set("prefixCls", value.asInstanceOf[js.Any])
  }
  
  type Props = CardProps
  
  implicit def make(companion: Card.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: CardProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
