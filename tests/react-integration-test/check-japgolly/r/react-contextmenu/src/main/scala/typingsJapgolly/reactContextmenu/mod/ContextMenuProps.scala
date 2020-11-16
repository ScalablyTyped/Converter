package typingsJapgolly.reactContextmenu.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ContextMenuProps extends js.Object {
  
  var className: js.UndefOr[String] = js.native
  
  var data: js.UndefOr[js.Any] = js.native
  
  var hideOnLeave: js.UndefOr[Boolean] = js.native
  
  var id: String = js.native
  
  var onHide: js.UndefOr[js.Function1[/* event */ js.Any, Unit]] = js.native
  
  var onMouseLeave: js.UndefOr[
    (js.Function3[
      /* event */ ReactMouseEventFrom[HTMLElement], 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
      /* target */ HTMLElement, 
      Unit
    ]) | js.Function
  ] = js.native
  
  var onShow: js.UndefOr[js.Function1[/* event */ js.Any, Unit]] = js.native
  
  var rtl: js.UndefOr[Boolean] = js.native
}
object ContextMenuProps {
  
  @scala.inline
  def apply(id: String): ContextMenuProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
    __obj.asInstanceOf[ContextMenuProps]
  }
  
  @scala.inline
  implicit class ContextMenuPropsOps[Self <: ContextMenuProps] (val x: Self) extends AnyVal {
    
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
    def setClassName(value: String): Self = this.set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteClassName: Self = this.set("className", js.undefined)
    
    @scala.inline
    def setData(value: js.Any): Self = this.set("data", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteData: Self = this.set("data", js.undefined)
    
    @scala.inline
    def setHideOnLeave(value: Boolean): Self = this.set("hideOnLeave", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteHideOnLeave: Self = this.set("hideOnLeave", js.undefined)
    
    @scala.inline
    def setOnHide(value: /* event */ js.Any => Callback): Self = this.set("onHide", js.Any.fromFunction1((t0: /* event */ js.Any) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnHide: Self = this.set("onHide", js.undefined)
    
    @scala.inline
    def setOnMouseLeaveFunction3(
      value: (/* event */ ReactMouseEventFrom[HTMLElement], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, /* target */ HTMLElement) => Callback
    ): Self = this.set("onMouseLeave", js.Any.fromFunction3((t0: /* event */ ReactMouseEventFrom[HTMLElement], t1: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, t2: /* target */ HTMLElement) => (value(t0, t1, t2)).runNow()))
    
    @scala.inline
    def setOnMouseLeave(
      value: (js.Function3[
          /* event */ ReactMouseEventFrom[HTMLElement], 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Object */ /* data */ js.Any, 
          /* target */ HTMLElement, 
          Unit
        ]) | js.Function
    ): Self = this.set("onMouseLeave", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteOnMouseLeave: Self = this.set("onMouseLeave", js.undefined)
    
    @scala.inline
    def setOnShow(value: /* event */ js.Any => Callback): Self = this.set("onShow", js.Any.fromFunction1((t0: /* event */ js.Any) => value(t0).runNow()))
    
    @scala.inline
    def deleteOnShow: Self = this.set("onShow", js.undefined)
    
    @scala.inline
    def setRtl(value: Boolean): Self = this.set("rtl", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteRtl: Self = this.set("rtl", js.undefined)
  }
}
