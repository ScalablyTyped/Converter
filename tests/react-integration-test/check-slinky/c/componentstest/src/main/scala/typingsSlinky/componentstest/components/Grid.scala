package typingsSlinky.componentstest.components

import typingsSlinky.componentstest.mod.CardGridProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Grid {
  
  @JSImport("componentstest", "Grid")
  @js.native
  object component extends js.Object
  
  def withProps(p: CardGridProps): SharedBuilder_CardGridProps_2000043299 = new SharedBuilder_CardGridProps_2000043299(js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: Grid.type): SharedBuilder_CardGridProps_2000043299 = new SharedBuilder_CardGridProps_2000043299(js.Array(this.component, js.Dictionary.empty))()
}
