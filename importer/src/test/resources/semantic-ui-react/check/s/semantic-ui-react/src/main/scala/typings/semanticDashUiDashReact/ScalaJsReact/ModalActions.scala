package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLAnchorElement
import typings.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandCollection
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesModalModalActionsMod.ModalActionsProps
import typings.semanticDashUiDashReact.srcModulesModalModalActionsMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className */
object ModalActions {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    actions: SemanticShorthandCollection[ButtonProps] = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    onActionClick: (/* event */ ReactMouseEventFrom[HTMLAnchorElement], /* data */ ButtonProps) => Callback = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[ModalActionsProps, default, Unit, ModalActionsProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type ModalActionsType = typings.semanticDashUiDashReact.srcModulesModalModalActionsMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (actions != null) __obj.updateDynamic("actions")(actions)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
        if (onActionClick != null) __obj.updateDynamic("onActionClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLAnchorElement], t1: /* data */ typings.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps) => onActionClick(t0, t1).runNow())))
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, ModalActionsType](js.constructorOf[ModalActionsType])
  
    f(props)(children: _*)
  }
  type Props = ModalActionsProps
}

