package typingsJapgolly.react.components

import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.react.mod.RefAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object VeryExotic {
  
  object Type {
    
    @JSImport("react/componentstest", "VeryExotic.type")
    @js.native
    val component: js.Object = js.native
    
    type Props = RefAttributes[HTMLDivElement]
    
    implicit def make(companion: Type.type): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: RefAttributes[HTMLDivElement]): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("react/componentstest", "VeryExotic")
  @js.native
  val component: js.Object = js.native
  
  type Props = RefAttributes[HTMLDivElement]
  
  implicit def make(companion: VeryExotic.type): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: RefAttributes[HTMLDivElement]): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
