package typings.reactDashContextmenu.japgolly

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.react.reactMod.HTMLAttributes
import typings.react.reactMod.ReactType
import typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTriggerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ContextMenuTrigger {
  def apply(
    id: String,
    attributes: HTMLAttributes[js.Any] = null,
    collect: js.UndefOr[/* data */ js.Any => CallbackTo[js.Any]] = js.undefined,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactType[js.Any] = null,
    key: js.UndefOr[Key] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ContextMenuTriggerProps, 
    typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger, 
    Unit, 
    ContextMenuTriggerProps
  ] = {
    val __obj = js.Dynamic.literal(id = id)
  
      if (attributes != null) __obj.updateDynamic("attributes")(attributes)
    collect.foreach(p => __obj.updateDynamic("collect")(js.Any.fromFunction1(((t0: /* data */ js.Any) => p(t0).runNow()))))
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable)
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTriggerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger](js.constructorOf[typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger])
    f(__obj.asInstanceOf[typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTriggerProps])(children: _*)
  }
}

