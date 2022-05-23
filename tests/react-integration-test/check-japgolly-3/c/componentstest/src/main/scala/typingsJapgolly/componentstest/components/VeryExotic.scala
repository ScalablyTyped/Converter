package typingsJapgolly.componentstest.components

import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.react.mod.RefAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object VeryExotic {
  
  object Type {
    
    @JSImport("componentstest", "VeryExotic.type")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Type.type): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: RefAttributes[HTMLDivElement]): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("componentstest", "VeryExotic")
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: VeryExotic.type): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: RefAttributes[HTMLDivElement]): SharedBuilder_RefAttributes_1542162006[HTMLDivElement] = new SharedBuilder_RefAttributes_1542162006[HTMLDivElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
