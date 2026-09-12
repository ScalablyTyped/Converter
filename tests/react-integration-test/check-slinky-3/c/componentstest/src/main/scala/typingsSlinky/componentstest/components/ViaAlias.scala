package typingsSlinky.componentstest.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent.Default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ViaAlias {
  
  @JSImport("componentstest", "ViaAlias")
  @js.native
  val component: js.Object = js.native
  
  type Props = /* import warning: importer.ImportType#apply Failed type conversion: M['props'] */ js.Any
  
  implicit def make(companion: ViaAlias.type): Default[tag.type, js.Object] = new Default[tag.type, js.Object](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: /* import warning: importer.ImportType#apply Failed type conversion: M['props'] */ js.Any): Default[tag.type, js.Object] = new Default[tag.type, js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
}
