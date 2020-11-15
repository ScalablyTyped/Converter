package typingsJapgolly.componentstest.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.componentstest.mod.CardGridProps
import typingsJapgolly.componentstest.mod.CardProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Card {
  
  @JSImport("componentstest", "Card")
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[js.Object] {
    
    @scala.inline
    def onClick(value: ReactMouseEventFrom[HTMLDivElement] => Callback): this.type = set("onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLDivElement]) => value(t0).runNow()))
    
    @scala.inline
    def prefixCls(value: String): this.type = set("prefixCls", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: CardProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: Card.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  object Grid2 {
    
    @JSImport("componentstest", "Card.Grid2")
    @js.native
    object component extends js.Object
    
    def withProps(p: CardGridProps): SharedBuilder_CardGridProps2094947949 = new SharedBuilder_CardGridProps2094947949(js.Array(this.component, p.asInstanceOf[js.Any]))
    
    implicit def make(companion: Grid2.type): SharedBuilder_CardGridProps2094947949 = new SharedBuilder_CardGridProps2094947949(js.Array(this.component, js.Dictionary.empty))()
  }
}
