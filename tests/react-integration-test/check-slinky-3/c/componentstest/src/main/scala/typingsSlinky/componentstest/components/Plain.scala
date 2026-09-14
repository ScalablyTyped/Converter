package typingsSlinky.componentstest.components

import org.scalajs.dom.HTMLAnchorElement
import typingsSlinky.componentstest.mod.DefaultComponentProps
import typingsSlinky.componentstest.mod.FooTypeMap
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Plain {
  
  @JSImport("componentstest", "Plain")
  @js.native
  val component: js.Object = js.native
  
  type Props = DefaultComponentProps[FooTypeMap]
  
  implicit def make(companion: Plain.type): SharedBuilder_DefaultComponentProps988386800[HTMLAnchorElement] = new SharedBuilder_DefaultComponentProps988386800[HTMLAnchorElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DefaultComponentProps[FooTypeMap]): SharedBuilder_DefaultComponentProps988386800[HTMLAnchorElement] = new SharedBuilder_DefaultComponentProps988386800[HTMLAnchorElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
