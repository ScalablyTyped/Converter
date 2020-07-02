package typingsJapgolly.stardustUiReactComponentEventListener.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import japgolly.scalajs.react.raw.React.RefHandle
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object EventListener {
  def apply[/* <: typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventTypes */ T](
    listener: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Callback,
    targetRef: RefHandle[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
    ],
    `type`: T,
    capture: js.UndefOr[Boolean] = js.undefined,
    key: Key = null,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    EventListenerOptions[T], 
    MountedWithRawType[EventListenerOptions[T], js.Object, RawMounted[EventListenerOptions[T], js.Object]]
  ] = {
    val __obj = js.Dynamic.literal(listener = js.Any.fromFunction1((t0: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any) => listener(t0).runNow()), targetRef = targetRef.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (!js.isUndefined(capture)) __obj.updateDynamic("capture")(capture.get.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = JsComponent[EventListenerOptions[T], Varargs, js.Object](this.componentImport)
    f(__obj.asInstanceOf[EventListenerOptions[T]])(children :_*)
  }
  @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}

