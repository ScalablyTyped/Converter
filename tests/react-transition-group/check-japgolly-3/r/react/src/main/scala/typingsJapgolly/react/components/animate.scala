package typingsJapgolly.react.components

import _root_.typingsJapgolly.StBuildingComponent.Default
import _root_.typingsJapgolly.react.mod.ClassAttributes
import org.scalajs.dom.SVGElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object animate {
  
  type Props = ClassAttributes[SVGElement]
  
  val component: String = "animate"
  
  implicit def make(companion: animate.type): Default[SVGElement] = new Default[SVGElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ClassAttributes[SVGElement]): Default[SVGElement] = new Default[SVGElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
