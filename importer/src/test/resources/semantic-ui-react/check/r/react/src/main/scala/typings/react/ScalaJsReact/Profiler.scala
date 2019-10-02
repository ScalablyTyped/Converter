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
  
    val __obj = js.Dynamic.literal()
  
    type ProfilerType = scala.scalajs.js.Object
  
          if (onRender != null) __obj.updateDynamic("onRender")(js.Any.fromFunction7(((t0: String, t1: mount | update, t2: Double, t3: Double, t4: Double, t5: Double, t6: js.Any ) => onRender(t0, t1, t2, t3, t4, t5, t6).runNow())))
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, ProfilerType](js.constructorOf[ProfilerType])
  
    f(props)
  }
  type Props = ProfilerProps
}

