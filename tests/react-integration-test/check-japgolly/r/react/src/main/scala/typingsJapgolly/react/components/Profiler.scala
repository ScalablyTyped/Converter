package typingsJapgolly.react.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.mod.ProfilerProps
import typingsJapgolly.react.reactStrings.mount
import typingsJapgolly.react.reactStrings.update
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Profiler {
  def apply(
    id: String,
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => Callback,
    key: Key = null,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    ProfilerProps, 
    MountedWithRawType[ProfilerProps, js.Object, RawMounted[ProfilerProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any], onRender = js.Any.fromFunction7((t0: /* id */ String, t1: /* phase */ mount | update, t2: /* actualDuration */ Double, t3: /* baseDuration */ Double, t4: /* startTime */ Double, t5: /* commitTime */ Double, t6: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any) => (onRender(t0, t1, t2, t3, t4, t5, t6)).runNow()))
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = JsComponent[ProfilerProps, Varargs, js.Object](this.componentImport)
    f(__obj.asInstanceOf[ProfilerProps])(children :_*)
  }
  @JSImport("react", "Profiler")
  @js.native
  object componentImport extends js.Object
  
}

