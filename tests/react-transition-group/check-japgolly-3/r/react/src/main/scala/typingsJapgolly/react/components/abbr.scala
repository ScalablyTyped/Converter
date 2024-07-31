package typingsJapgolly.react.components

import _root_.typingsJapgolly.StBuildingComponent.Default
import _root_.typingsJapgolly.react.anon.Html
import _root_.typingsJapgolly.react.mod.DetailedHTMLProps
import _root_.typingsJapgolly.react.mod.HTMLAttributes
import org.scalajs.dom.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object abbr {
  
  inline def apply(dangerouslySetInnerHTML: Html = null, defaultChecked: js.UndefOr[Boolean] = js.undefined): Default[HTMLElement] = {
    val __props = js.Dynamic.literal()
    if (dangerouslySetInnerHTML != null) __props.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __props.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    new Default[HTMLElement](js.Array(this.component, __props.asInstanceOf[DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]]))
  }
  
  type Props = DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]
  
  val component: String = "abbr"
  
  implicit def make(companion: abbr.type): Default[HTMLElement] = new Default[HTMLElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Default[HTMLElement] = new Default[HTMLElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
