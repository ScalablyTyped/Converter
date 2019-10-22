package typings.semanticUiReact.jagpolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLAnchorElement
import typings.semanticUiReact.elementsButtonButtonMod.ButtonProps
import typings.semanticUiReact.genericMod.SemanticShorthandCollection
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.modulesModalModalActionsMod.ModalActionsProps
import typings.semanticUiReact.modulesModalModalActionsMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ModalActions {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    actions: SemanticShorthandCollection[ButtonProps] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    onActionClick: (/* event */ ReactMouseEventFrom[HTMLAnchorElement], /* data */ ButtonProps) => Callback = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[ModalActionsProps, default, Unit, ModalActionsProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (actions != null) __obj.updateDynamic("actions")(actions)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (onActionClick != null) __obj.updateDynamic("onActionClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLAnchorElement], t1: /* data */ typings.semanticUiReact.elementsButtonButtonMod.ButtonProps) => onActionClick(t0, t1).runNow())))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesModalModalActionsMod.ModalActionsProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesModalModalActionsMod.default](js.constructorOf[typings.semanticUiReact.modulesModalModalActionsMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesModalModalActionsMod.ModalActionsProps])(children: _*)
  }
}

