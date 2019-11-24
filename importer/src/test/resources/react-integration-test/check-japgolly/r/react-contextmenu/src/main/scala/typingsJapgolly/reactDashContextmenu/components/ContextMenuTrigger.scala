package typingsJapgolly.reactDashContextmenu.components

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.reactMod.HTMLAttributes
import typingsJapgolly.react.reactMod.ReactType
import typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTriggerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ContextMenuTrigger {
  def apply(
    id: String,
    attributes: HTMLAttributes[_] = null,
    collect: /* data */ js.Any => CallbackTo[_] = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactType[_] = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ContextMenuTriggerProps, 
    typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger, 
    Unit, 
    ContextMenuTriggerProps
  ] = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any])
  
      if (attributes != null) __obj.updateDynamic("attributes")(attributes.asInstanceOf[js.Any])
    if (collect != null) __obj.updateDynamic("collect")(js.Any.fromFunction1((t0: /* data */ js.Any) => collect(t0).runNow()))
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable.asInstanceOf[js.Any])
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTriggerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTriggerProps])(children: _*)
  }
  @JSImport("react-contextmenu", "ContextMenuTrigger")
  @js.native
  object componentImport extends js.Object
  
}

