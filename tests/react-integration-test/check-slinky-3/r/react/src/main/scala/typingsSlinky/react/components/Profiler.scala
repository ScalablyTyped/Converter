package typingsSlinky.react.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent.Default
import typingsSlinky.react.mod.ProfilerProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Profiler {
  
  inline def apply(
    id: String,
    onRender: (/* id */ String, /* phase */ "mount" | "update", /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ Any) => Unit
  ): Default[tag.type, js.Object] = {
    val __props = js.Dynamic.literal(id = id.asInstanceOf[js.Any], onRender = js.Any.fromFunction7(onRender))
    new Default[tag.type, js.Object](js.Array(this.component, __props.asInstanceOf[ProfilerProps]))
  }
  
  @JSImport("react", "Profiler")
  @js.native
  val component: js.Object = js.native
  
  type Props = ProfilerProps
  
  def withProps(p: ProfilerProps): Default[tag.type, js.Object] = new Default[tag.type, js.Object](js.Array(this.component, p.asInstanceOf[js.Any]))
}
