package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.reactStrings.mount
import typingsJapgolly.react.reactStrings.update
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ProfilerProps extends js.Object {
  
  var children: js.UndefOr[Node] = js.native
  
  var id: String = js.native
  
  var onRender: ProfilerOnRenderCallback = js.native
}
object ProfilerProps {
  
  @scala.inline
  def apply(
    id: String,
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Callback
  ): ProfilerProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any], onRender = js.Any.fromFunction7((t0: /* id */ String, t1: /* phase */ mount | update, t2: /* actualDuration */ Double, t3: /* baseDuration */ Double, t4: /* startTime */ Double, t5: /* commitTime */ Double, t6: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => (onRender(t0, t1, t2, t3, t4, t5, t6)).runNow()))
    __obj.asInstanceOf[ProfilerProps]
  }
  
  @scala.inline
  implicit class ProfilerPropsOps[Self <: ProfilerProps] (val x: Self) extends AnyVal {
    
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
    def setOnRender(
      value: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Callback
    ): Self = this.set("onRender", js.Any.fromFunction7((t0: /* id */ String, t1: /* phase */ mount | update, t2: /* actualDuration */ Double, t3: /* baseDuration */ Double, t4: /* startTime */ Double, t5: /* commitTime */ Double, t6: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => (value(t0, t1, t2, t3, t4, t5, t6)).runNow()))
    
    @scala.inline
    def setChildrenVdomElement(value: VdomElement): Self = this.set("children", value.rawElement.asInstanceOf[js.Any])
    
    @scala.inline
    def setChildren(value: VdomNode): Self = this.set("children", value.rawNode.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteChildren: Self = this.set("children", js.undefined)
  }
}
