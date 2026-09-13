package typingsJapgolly.componentstest.components

import org.scalajs.dom.HTMLAnchorElement
import typingsJapgolly.componentstest.mod.DefaultComponentProps
import typingsJapgolly.componentstest.mod.FooTypeMap
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Inline {
  
  @JSImport("componentstest", "Inline")
  @js.native
  val component: js.Object = js.native
  
  type Props = DefaultComponentProps[FooTypeMap]
  
  implicit def make(companion: Inline.type): SharedBuilder_DefaultComponentProps833350959[HTMLAnchorElement] = new SharedBuilder_DefaultComponentProps833350959[HTMLAnchorElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DefaultComponentProps[FooTypeMap]): SharedBuilder_DefaultComponentProps833350959[HTMLAnchorElement] = new SharedBuilder_DefaultComponentProps833350959[HTMLAnchorElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
