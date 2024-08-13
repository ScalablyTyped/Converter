package typingsSlinky.react.components

import typingsSlinky.react.componentstestMod.CardGridProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Grid {
  
  @JSImport("react/componentstest", "Grid")
  @js.native
  val component: js.Object = js.native
  
  type Props = CardGridProps
  
  implicit def make(companion: Grid.type): SharedBuilder_CardGridProps_1326759902 = new SharedBuilder_CardGridProps_1326759902(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: CardGridProps): SharedBuilder_CardGridProps_1326759902 = new SharedBuilder_CardGridProps_1326759902(js.Array(this.component, p.asInstanceOf[js.Any]))
}
