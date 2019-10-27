package typings.reactContextmenu.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.react.reactMod.HTMLAttributes
import typings.react.reactMod.ReactType
import typings.reactContextmenu.Fn_DataAny
import typings.reactContextmenu.reactContextmenuMod.ContextMenuTriggerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ContextMenuTrigger {
  def apply(
    id: String,
    key: js.UndefOr[Key] = js.undefined,
    attributes: HTMLAttributes[js.Any] = null,
    collect: Fn_DataAny = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactType[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ContextMenuTriggerProps, 
    typings.reactContextmenu.reactContextmenuMod.ContextMenuTrigger, 
    Unit, 
    ContextMenuTriggerProps
  ] = {
    val __obj = js.Dynamic.literal(id = id)
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (attributes != null) __obj.updateDynamic("attributes")(attributes)
    if (collect != null) __obj.updateDynamic("collect")(collect)
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable)
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactContextmenu.reactContextmenuMod.ContextMenuTriggerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactContextmenu.reactContextmenuMod.ContextMenuTrigger](js.constructorOf[typings.reactContextmenu.reactContextmenuMod.ContextMenuTrigger])
    f(__obj.asInstanceOf[typings.reactContextmenu.reactContextmenuMod.ContextMenuTriggerProps])(children: _*)
  }
}

