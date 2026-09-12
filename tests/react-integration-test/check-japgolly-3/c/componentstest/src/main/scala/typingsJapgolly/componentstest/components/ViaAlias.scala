package typingsJapgolly.componentstest.components

import typingsJapgolly.StBuildingComponent.Default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ViaAlias {
  
  @JSImport("componentstest", "ViaAlias")
  @js.native
  val component: js.Object = js.native
  
  type Props = /* import warning: importer.ImportType#apply Failed type conversion: M['props'] */ js.Any
  
  implicit def make(companion: ViaAlias.type): Default[js.Object] = new Default[js.Object](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: /* import warning: importer.ImportType#apply Failed type conversion: M['props'] */ js.Any): Default[js.Object] = new Default[js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
}
