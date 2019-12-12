package typingsSlinky.react.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.react.reactMod.ProfilerProps
import typingsSlinky.react.reactStrings.mount
import typingsSlinky.react.reactStrings.update
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Profiler {
  object raw
    extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
    @JSImport("react", "Profiler")
    @js.native
    object componentImport extends js.Object
    
    override val component: String | js.Object = this.componentImport
    type Props = ProfilerProps
  }
  
  /* The following DOM/SVG props were specified: id */
  def apply(
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Unit,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal(onRender = js.Any.fromFunction7(onRender))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

