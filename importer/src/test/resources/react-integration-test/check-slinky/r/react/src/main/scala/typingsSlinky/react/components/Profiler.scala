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

/* The following DOM/SVG props were specified: id */
object Profiler
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  override val component: String | js.Object = typingsSlinky.react.reactMod.Profiler.asInstanceOf[String | js.Object]
  def apply(
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Unit,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal(onRender = js.Any.fromFunction7(onRender))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ProfilerProps
}

