package typings.japgolly.react

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.react.reactMod.ProfilerProps
import typings.react.reactStrings.mount
import typings.react.reactStrings.update
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Profiler {
  def apply(
    id: String,
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Callback,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    ProfilerProps, 
    MountedWithRawType[ProfilerProps, js.Object, RawMounted[ProfilerProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal(id = id)
  
      __obj.updateDynamic("onRender")(js.Any.fromFunction7(((t0: /* id */ java.lang.String, t1: /* phase */ typings.react.reactStrings.mount | typings.react.reactStrings.update, t2: /* actualDuration */ scala.Double, t3: /* baseDuration */ scala.Double, t4: /* startTime */ scala.Double, t5: /* commitTime */ scala.Double, t6: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => onRender(t0, t1, t2, t3, t4, t5, t6).runNow())))
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.react.reactMod.ProfilerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.react.reactMod.Profiler)
    f(__obj.asInstanceOf[typings.react.reactMod.ProfilerProps])(children: _*)
  }
}

