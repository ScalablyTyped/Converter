package typingsSlinky.react.components

import org.scalajs.dom.raw.SVGElement
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent.Default
import typingsSlinky.react.mod.ClassAttributes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object animate {
  val component: String = "animate"
  def withProps(p: ClassAttributes[SVGElement]): Default[tag.type, SVGElement with js.Object] = new Default[tag.type, SVGElement with js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: animate.type): Default[tag.type, SVGElement with js.Object] = new Default[tag.type, SVGElement with js.Object](js.Array(this.component, js.Dictionary.empty))()
}

