package typings.semanticUiReact.japgolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsTestContainerTestContainerMod.TestContainerProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object TestContainer {
  def apply(
    requiredFn0Number: CallbackTo[Double],
    requiredFn0Void: Callback,
    requiredFn1Number: Double => CallbackTo[Double],
    requiredFn1Void: Double => Callback,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    optFn0Number: js.UndefOr[CallbackTo[Double]] = js.undefined,
    optFn0Void: js.UndefOr[Callback] = js.undefined,
    optFn1Number: js.UndefOr[/* x */ Double => CallbackTo[Double]] = js.undefined,
    optFn1Void: js.UndefOr[/* x */ Double => Callback] = js.undefined,
    text: js.UndefOr[Boolean] = js.undefined,
    textAlign: SemanticTEXTALIGNMENTS = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    TestContainerProps, 
    MountedWithRawType[TestContainerProps, js.Object, RawMounted[TestContainerProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      __obj.updateDynamic("requiredFn0Number")(js.Any.fromFunction0((() => requiredFn0Number.runNow())))
    __obj.updateDynamic("requiredFn0Void")(js.Any.fromFunction0((() => requiredFn0Void.runNow())))
    __obj.updateDynamic("requiredFn1Number")(js.Any.fromFunction1(((t0: scala.Double) => requiredFn1Number(t0).runNow())))
    __obj.updateDynamic("requiredFn1Void")(js.Any.fromFunction1(((t0: scala.Double) => requiredFn1Void(t0).runNow())))
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    optFn0Number.foreach(p => __obj.updateDynamic("optFn0Number")(js.Any.fromFunction0((() => p.runNow()))))
    optFn0Void.foreach(p => __obj.updateDynamic("optFn0Void")(js.Any.fromFunction0((() => p.runNow()))))
    optFn1Number.foreach(p => __obj.updateDynamic("optFn1Number")(js.Any.fromFunction1(((t0: /* x */ scala.Double) => p(t0).runNow()))))
    optFn1Void.foreach(p => __obj.updateDynamic("optFn1Void")(js.Any.fromFunction1(((t0: /* x */ scala.Double) => p(t0).runNow()))))
    if (!js.isUndefined(text)) __obj.updateDynamic("text")(text)
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsTestContainerTestContainerMod.TestContainerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsTestContainerMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsTestContainerTestContainerMod.TestContainerProps])(children: _*)
  }
}

