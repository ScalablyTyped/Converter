package typingsSlinky.react.components

import org.scalajs.dom.raw.SVGElement
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent.Default
import typingsSlinky.react.mod.ClassAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object animate {
  
  val component: String = "animate"
  
  implicit def make(companion: animate.type): Default[tag.type, SVGElement] = new Default[tag.type, SVGElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ClassAttributes[SVGElement]): Default[tag.type, SVGElement] = new Default[tag.type, SVGElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
