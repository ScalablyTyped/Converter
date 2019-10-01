package typings.react.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.react.reactMod.ProfilerProps
import typings.react.reactStrings.mount
import typings.react.reactStrings.update
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: id */
object Profiler {
  def apply(
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Callback
  )(
    
  ): UnmountedWithRoot[ProfilerProps, js.Object, Unit, ProfilerProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal(onRender = js.Any.fromFunction7(onRender))
  
    type ProfilerType = scala.scalajs.js.Object
  
    
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, ProfilerType](js.constructorOf[ProfilerType])
  
    f(props)
  }
  type Props = ProfilerProps
}

