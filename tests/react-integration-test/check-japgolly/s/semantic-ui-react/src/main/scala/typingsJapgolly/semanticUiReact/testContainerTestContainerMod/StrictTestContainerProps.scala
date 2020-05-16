package typingsJapgolly.semanticUiReact.testContainerTestContainerMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import typingsJapgolly.semanticUiReact.genericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictTestContainerProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** Primary content. */
  var children: js.UndefOr[Node] = js.native
  /** Additional classes. */
  var className: js.UndefOr[String] = js.native
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.native
  /** TestContainer has no maximum width. */
  var fluid: js.UndefOr[Boolean] = js.native
  /**Should be CallbackTo[Number]*/
  var optFn0Number: js.UndefOr[js.Function0[Double]] = js.native
  /**Should be Callback*/
  var optFn0Void: js.UndefOr[js.Function0[Unit]] = js.native
  /**Should be (x:Number) => CallbackTo[Number]*/
  var optFn1Number: js.UndefOr[js.Function1[/* x */ Double, Double]] = js.native
  /**Should be (x:Number) => Callback*/
  var optFn1Void: js.UndefOr[js.Function1[/* x */ Double, Unit]] = js.native
  /** Reduce maximum width to more naturally accommodate text. */
  var text: js.UndefOr[Boolean] = js.native
  /** Describes how the text inside this component should be aligned. */
  var textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.native
  /**Should be CallbackTo[Number]*/
  def requiredFn0Number(): Double = js.native
  /**Should be Callback*/
  def requiredFn0Void(): Unit = js.native
  /**Should be (x:Number) => CallbackTo[Number]*/
  def requiredFn1Number(x: Double): Double = js.native
  /**Should be (x:Number) => Callback*/
  def requiredFn1Void(x: Double): Unit = js.native
}

object StrictTestContainerProps {
  @scala.inline
  def apply(
    requiredFn0Number: CallbackTo[Double],
    requiredFn0Void: Callback,
    requiredFn1Number: Double => CallbackTo[Double],
    requiredFn1Void: Double => Callback
  ): StrictTestContainerProps = {
    val __obj = js.Dynamic.literal(requiredFn0Number = requiredFn0Number.toJsFn, requiredFn0Void = requiredFn0Void.toJsFn, requiredFn1Number = js.Any.fromFunction1((t0: Double) => requiredFn1Number(t0).runNow()), requiredFn1Void = js.Any.fromFunction1((t0: Double) => requiredFn1Void(t0).runNow()))
    __obj.asInstanceOf[StrictTestContainerProps]
  }
  @scala.inline
  implicit class StrictTestContainerPropsOps[Self <: StrictTestContainerProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withRequiredFn0Number(value: CallbackTo[Double]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("requiredFn0Number")(value.toJsFn)
        ret
    }
    @scala.inline
    def withRequiredFn0Void(value: Callback): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("requiredFn0Void")(value.toJsFn)
        ret
    }
    @scala.inline
    def withRequiredFn1Number(value: Double => CallbackTo[Double]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("requiredFn1Number")(js.Any.fromFunction1((t0: Double) => value(t0).runNow()))
        ret
    }
    @scala.inline
    def withRequiredFn1Void(value: Double => Callback): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("requiredFn1Void")(js.Any.fromFunction1((t0: Double) => value(t0).runNow()))
        ret
    }
    @scala.inline
    def withAs(value: js.Any): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("as")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutAs: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("as")(js.undefined)
        ret
    }
    @scala.inline
    def withChildrenVdomElement(value: VdomElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(value.rawElement.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withChildren(value: VdomNode): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(value.rawNode.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(js.undefined)
        ret
    }
    @scala.inline
    def withClassName(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("className")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutClassName: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("className")(js.undefined)
        ret
    }
    @scala.inline
    def withContentVdomElement(value: VdomElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("content")(value.rawElement.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withContent(value: SemanticShorthandContent): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("content")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutContent: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("content")(js.undefined)
        ret
    }
    @scala.inline
    def withFluid(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("fluid")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutFluid: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("fluid")(js.undefined)
        ret
    }
    @scala.inline
    def withOptFn0Number(value: CallbackTo[Double]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn0Number")(value.toJsFn)
        ret
    }
    @scala.inline
    def withoutOptFn0Number: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn0Number")(js.undefined)
        ret
    }
    @scala.inline
    def withOptFn0Void(value: Callback): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn0Void")(value.toJsFn)
        ret
    }
    @scala.inline
    def withoutOptFn0Void: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn0Void")(js.undefined)
        ret
    }
    @scala.inline
    def withOptFn1Number(value: /* x */ Double => CallbackTo[Double]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn1Number")(js.Any.fromFunction1((t0: /* x */ Double) => value(t0).runNow()))
        ret
    }
    @scala.inline
    def withoutOptFn1Number: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn1Number")(js.undefined)
        ret
    }
    @scala.inline
    def withOptFn1Void(value: /* x */ Double => Callback): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn1Void")(js.Any.fromFunction1((t0: /* x */ Double) => value(t0).runNow()))
        ret
    }
    @scala.inline
    def withoutOptFn1Void: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("optFn1Void")(js.undefined)
        ret
    }
    @scala.inline
    def withText(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("text")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutText: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("text")(js.undefined)
        ret
    }
    @scala.inline
    def withTextAlign(value: SemanticTEXTALIGNMENTS): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("textAlign")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutTextAlign: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("textAlign")(js.undefined)
        ret
    }
  }
  
}

