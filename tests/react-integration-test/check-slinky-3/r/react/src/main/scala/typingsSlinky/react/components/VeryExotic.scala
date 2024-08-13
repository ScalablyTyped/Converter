package typingsSlinky.react.components

import org.scalajs.dom.HTMLDivElement
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent.Default
import typingsSlinky.react.mod.RefAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object VeryExotic {
  
  @JSImport("react/componentstest", "VeryExotic")
  @js.native
  val component: js.Object = js.native
  
  type Props = RefAttributes[HTMLDivElement]
  
  implicit def make(companion: VeryExotic.type): Default[tag.type, HTMLDivElement] = new Default[tag.type, HTMLDivElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: RefAttributes[HTMLDivElement]): Default[tag.type, HTMLDivElement] = new Default[tag.type, HTMLDivElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
