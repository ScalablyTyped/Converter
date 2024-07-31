package typingsSlinky.react.components

import _root_.typingsSlinky.StBuildingComponent.Default
import _root_.typingsSlinky.react.mod.ClassAttributes
import org.scalajs.dom.SVGElement
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object animate {
  
  type Props = ClassAttributes[SVGElement]
  
  val component: String = "animate"
  
  implicit def make(companion: animate.type): Default[tag.type, SVGElement] = new Default[tag.type, SVGElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ClassAttributes[SVGElement]): Default[tag.type, SVGElement] = new Default[tag.type, SVGElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
