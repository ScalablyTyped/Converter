package typings.semanticDashUiDashReact.srcElementsTestContainerTestContainerMod

import slinky.core.TagMod
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StrictTestContainerProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.undefined
  /** Primary content. */
  var children: js.UndefOr[TagMod[Any]] = js.undefined
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
    requiredFn0Number: () => Double,
    requiredFn0Void: () => Unit,
    requiredFn1Number: Double => Double,
    requiredFn1Void: Double => Unit,
    as: js.Any = null,
    children: TagMod[Any] = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    optFn0Number: () => Double = null,
    optFn0Void: () => Unit = null,
    optFn1Number: /* x */ Double => Double = null,
    optFn1Void: /* x */ Double => Unit = null,
    text: js.UndefOr[Boolean] = js.undefined,
    textAlign: SemanticTEXTALIGNMENTS = null
  ): StrictTestContainerProps = {
    val __obj = js.Dynamic.literal(requiredFn0Number = js.Any.fromFunction0(requiredFn0Number), requiredFn0Void = js.Any.fromFunction0(requiredFn0Void), requiredFn1Number = js.Any.fromFunction1(requiredFn1Number), requiredFn1Void = js.Any.fromFunction1(requiredFn1Void))
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (optFn0Number != null) __obj.updateDynamic("optFn0Number")(js.Any.fromFunction0(optFn0Number))
    if (optFn0Void != null) __obj.updateDynamic("optFn0Void")(js.Any.fromFunction0(optFn0Void))
    if (optFn1Number != null) __obj.updateDynamic("optFn1Number")(js.Any.fromFunction1(optFn1Number))
    if (optFn1Void != null) __obj.updateDynamic("optFn1Void")(js.Any.fromFunction1(optFn1Void))
    if (!js.isUndefined(text)) __obj.updateDynamic("text")(text)
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign)
    __obj.asInstanceOf[StrictTestContainerProps]
  }
}

