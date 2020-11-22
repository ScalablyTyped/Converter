package typingsJapgolly.react.components

import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.react.anon.Html
import typingsJapgolly.react.mod.DetailedHTMLProps
import typingsJapgolly.react.mod.HTMLAttributes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object abbr {
  
  val component: String = "abbr"
  
  def withProps(p: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Default[HTMLElement with js.Object] = new Default[HTMLElement with js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  @scala.inline
  def apply(dangerouslySetInnerHTML: Html = null, defaultChecked: js.UndefOr[Boolean] = js.undefined): Default[HTMLElement with js.Object] = {
    val __props = js.Dynamic.literal()
    if (dangerouslySetInnerHTML != null) __props.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __props.updateDynamic("defaultChecked")(defaultChecked.get.asInstanceOf[js.Any])
    new Default[HTMLElement with js.Object](js.Array(this.component, __props.asInstanceOf[DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]]))
  }
  
  implicit def make(companion: abbr.type): Default[HTMLElement with js.Object] = new Default[HTMLElement with js.Object](js.Array(this.component, js.Dictionary.empty))()
}
