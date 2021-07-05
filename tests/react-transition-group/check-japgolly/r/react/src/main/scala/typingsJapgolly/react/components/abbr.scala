package typingsJapgolly.react.components

import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.react.anon.Html
import typingsJapgolly.react.mod.DetailedHTMLProps
import typingsJapgolly.react.mod.HTMLAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object abbr {
  
  @scala.inline
  def apply(dangerouslySetInnerHTML: Html = null, defaultChecked: js.UndefOr[Boolean] = js.undefined): Default[HTMLElement] = {
    val __props = js.Dynamic.literal()
    if (dangerouslySetInnerHTML != null) __props.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __props.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    new Default[HTMLElement](js.Array(this.component, __props.asInstanceOf[DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]]))
  }
  
  val component: String = "abbr"
  
  implicit def make(companion: abbr.type): Default[HTMLElement] = new Default[HTMLElement](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Default[HTMLElement] = new Default[HTMLElement](js.Array(this.component, p.asInstanceOf[js.Any]))
}
