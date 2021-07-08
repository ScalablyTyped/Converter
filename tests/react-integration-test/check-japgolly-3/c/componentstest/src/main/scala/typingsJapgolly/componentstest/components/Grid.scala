package typingsJapgolly.componentstest.components

import typingsJapgolly.componentstest.mod.CardGridProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Grid {
  
  @JSImport("componentstest", "Grid")
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: Grid.type): SharedBuilder_CardGridProps2094947949 = new SharedBuilder_CardGridProps2094947949(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: CardGridProps): SharedBuilder_CardGridProps2094947949 = new SharedBuilder_CardGridProps2094947949(js.Array(this.component, p.asInstanceOf[js.Any]))
}
