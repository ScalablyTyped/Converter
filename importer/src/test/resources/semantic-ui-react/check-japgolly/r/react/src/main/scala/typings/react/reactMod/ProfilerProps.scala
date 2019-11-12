package typings.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import typings.react.reactStrings.mount
import typings.react.reactStrings.update
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ProfilerProps extends js.Object {
  var children: js.UndefOr[Node] = js.undefined
  var id: String
  var onRender: ProfilerOnRenderCallback
}

object ProfilerProps {
  @scala.inline
  def apply(
    id: String,
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Callback,
    children: VdomNode = null
  ): ProfilerProps = {
    val __obj = js.Dynamic.literal(id = id)
    __obj.updateDynamic("onRender")(js.Any.fromFunction7(((t0: /* id */ java.lang.String, t1: /* phase */ typings.react.reactStrings.mount | typings.react.reactStrings.update, t2: /* actualDuration */ scala.Double, t3: /* baseDuration */ scala.Double, t4: /* startTime */ scala.Double, t5: /* commitTime */ scala.Double, t6: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => onRender(t0, t1, t2, t3, t4, t5, t6).runNow())))
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    __obj.asInstanceOf[ProfilerProps]
  }
}

