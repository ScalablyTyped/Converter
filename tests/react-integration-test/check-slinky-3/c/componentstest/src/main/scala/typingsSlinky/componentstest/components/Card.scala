package typingsSlinky.componentstest.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.componentstest.mod.CardGridProps
import _root_.typingsSlinky.componentstest.mod.CardProps
import org.scalajs.dom.HTMLDivElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Card {
  
  object Grid2 {
    
    @JSImport("componentstest", "Card.Grid2")
    @js.native
    val component: js.Object = js.native
    
    type Props = CardGridProps
    
    implicit def make(companion: Grid2.type): SharedBuilder_CardGridProps_2000043299 = new SharedBuilder_CardGridProps_2000043299(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: CardGridProps): SharedBuilder_CardGridProps_2000043299 = new SharedBuilder_CardGridProps_2000043299(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("componentstest", "Card")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    inline def onClick(value: SyntheticMouseEvent[HTMLDivElement] => Unit): this.type = set("onClick", js.Any.fromFunction1(value))
    
    inline def prefixCls(value: String): this.type = set("prefixCls", value.asInstanceOf[js.Any])
  }
  
  type Props = CardProps
  
  implicit def make(companion: Card.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: CardProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
