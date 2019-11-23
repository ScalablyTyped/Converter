package typings.semanticDashUiDashReact.srcElementsTestContainerTestContainerMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictTestContainerProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.undefined
  /** Primary content. */
  var children: js.UndefOr[Node] = js.undefined
  /** Additional classes. */
  var className: js.UndefOr[String] = js.undefined
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.undefined
  /** TestContainer has no maximum width. */
  var fluid: js.UndefOr[Boolean] = js.undefined
  /**Should be CallbackTo[Number]*/
  var optFn0Number: js.UndefOr[js.Function0[Double]] = js.undefined
  /**Should be Callback*/
  var optFn0Void: js.UndefOr[js.Function0[Unit]] = js.undefined
  /**Should be (x:Number) => CallbackTo[Number]*/
  var optFn1Number: js.UndefOr[js.Function1[/* x */ Double, Double]] = js.undefined
  /**Should be (x:Number) => Callback*/
  var optFn1Void: js.UndefOr[js.Function1[/* x */ Double, Unit]] = js.undefined
  /** Reduce maximum width to more naturally accommodate text. */
  var text: js.UndefOr[Boolean] = js.undefined
  /** Describes how the text inside this component should be aligned. */
  var textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined
  /**Should be CallbackTo[Number]*/
  def requiredFn0Number(): Double
  /**Should be Callback*/
  def requiredFn0Void(): Unit
  /**Should be (x:Number) => CallbackTo[Number]*/
  def requiredFn1Number(x: Double): Double
  /**Should be (x:Number) => Callback*/
  def requiredFn1Void(x: Double): Unit
}

object StrictTestContainerProps {
  @scala.inline
  def apply(
    requiredFn0Number: CallbackTo[Double],
    requiredFn0Void: Callback,
    requiredFn1Number: Double => CallbackTo[Double],
    requiredFn1Void: Double => Callback,
    as: js.Any = null,
    children: VdomNode = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    optFn0Number: js.UndefOr[CallbackTo[Double]] = js.undefined,
    optFn0Void: js.UndefOr[Callback] = js.undefined,
    optFn1Number: /* x */ Double => CallbackTo[Double] = null,
    optFn1Void: /* x */ Double => Callback = null,
    text: js.UndefOr[Boolean] = js.undefined,
    textAlign: SemanticTEXTALIGNMENTS = null
  ): StrictTestContainerProps = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("requiredFn0Number")(requiredFn0Number.toJsFn)
    __obj.updateDynamic("requiredFn0Void")(requiredFn0Void.toJsFn)
    __obj.updateDynamic("requiredFn1Number")(js.Any.fromFunction1((t0: scala.Double) => requiredFn1Number(t0).runNow()))
    __obj.updateDynamic("requiredFn1Void")(js.Any.fromFunction1((t0: scala.Double) => requiredFn1Void(t0).runNow()))
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    optFn0Number.foreach(p => __obj.updateDynamic("optFn0Number")(p.toJsFn))
    optFn0Void.foreach(p => __obj.updateDynamic("optFn0Void")(p.toJsFn))
    if (optFn1Number != null) __obj.updateDynamic("optFn1Number")(js.Any.fromFunction1((t0: /* x */ scala.Double) => optFn1Number(t0).runNow()))
    if (optFn1Void != null) __obj.updateDynamic("optFn1Void")(js.Any.fromFunction1((t0: /* x */ scala.Double) => optFn1Void(t0).runNow()))
    if (!js.isUndefined(text)) __obj.updateDynamic("text")(text)
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign)
    __obj.asInstanceOf[StrictTestContainerProps]
  }
}

