package typingsSlinky.reactContextmenu.mod

import slinky.core.ReactComponentClass
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.react.mod.ReactType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ContextMenuTriggerProps extends js.Object {
  
  var attributes: js.UndefOr[HTMLAttributes[_]] = js.native
  
  var collect: js.UndefOr[js.Function1[/* data */ js.Any, _]] = js.native
  
  var disable: js.UndefOr[Boolean] = js.native
  
  var holdToDisplay: js.UndefOr[Double] = js.native
  
  var id: String = js.native
  
  var renderTag: js.UndefOr[ReactType[_]] = js.native
}
object ContextMenuTriggerProps {
  
  @scala.inline
  def apply(id: String): ContextMenuTriggerProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuTriggerProps]
  }
  
  @scala.inline
  implicit class ContextMenuTriggerPropsOps[Self <: ContextMenuTriggerProps] (val x: Self) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setId(value: String): Self = this.set("id", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAttributes(value: HTMLAttributes[_]): Self = this.set("attributes", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteAttributes: Self = this.set("attributes", js.undefined)
    
    @scala.inline
    def setCollect(value: /* data */ js.Any => _): Self = this.set("collect", js.Any.fromFunction1(value))
    
    @scala.inline
    def deleteCollect: Self = this.set("collect", js.undefined)
    
    @scala.inline
    def setDisable(value: Boolean): Self = this.set("disable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteDisable: Self = this.set("disable", js.undefined)
    
    @scala.inline
    def setHoldToDisplay(value: Double): Self = this.set("holdToDisplay", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteHoldToDisplay: Self = this.set("holdToDisplay", js.undefined)
    
    @scala.inline
    def setRenderTagFunctionComponent(value: ReactComponentClass[_]): Self = this.set("renderTag", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRenderTagComponentClass(value: ReactComponentClass[_]): Self = this.set("renderTag", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRenderTag(value: ReactType[_]): Self = this.set("renderTag", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteRenderTag: Self = this.set("renderTag", js.undefined)
  }
}
