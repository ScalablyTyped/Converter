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
    __obj.updateDynamic("requiredFn1Number")(js.Any.fromFunction1((t0: Double) => requiredFn1Number(t0).runNow()))
    __obj.updateDynamic("requiredFn1Void")(js.Any.fromFunction1((t0: Double) => requiredFn1Void(t0).runNow()))
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
    optFn0Number.foreach(p => __obj.updateDynamic("optFn0Number")(p.toJsFn))
    optFn0Void.foreach(p => __obj.updateDynamic("optFn0Void")(p.toJsFn))
    if (optFn1Number != null) __obj.updateDynamic("optFn1Number")(js.Any.fromFunction1((t0: /* x */ Double) => optFn1Number(t0).runNow()))
    if (optFn1Void != null) __obj.updateDynamic("optFn1Void")(js.Any.fromFunction1((t0: /* x */ Double) => optFn1Void(t0).runNow()))
    if (!js.isUndefined(text)) __obj.updateDynamic("text")(text.asInstanceOf[js.Any])
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictTestContainerProps]
  }
  @scala.inline
  implicit class StrictTestContainerPropsOps[Self <: StrictTestContainerProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withRequiredFn0Number(requiredFn0Number: CallbackTo[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn0Number")(requiredFn0Number.toJsFn)
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRequiredFn0Void(requiredFn0Void: Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn0Void")(requiredFn0Void.toJsFn)
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRequiredFn1Number(requiredFn1Number: Double => CallbackTo[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn1Number")(js.Any.fromFunction1((t0: Double) => requiredFn1Number(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRequiredFn1Void(requiredFn1Void: Double => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn1Void")(js.Any.fromFunction1((t0: Double) => requiredFn1Void(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAs(as: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (as != null) ret.updateDynamic("as")(as.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAs: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "as")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withChildrenVdomElement(children: VdomElement): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withChildren(children: VdomNode): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withClassName(className: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (className != null) ret.updateDynamic("className")(className.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutClassName: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "className")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withContentVdomElement(content: VdomElement): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (content != null) ret.updateDynamic("content")(content.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withContent(content: SemanticShorthandContent): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (content != null) ret.updateDynamic("content")(content.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutContent: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "content")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFluid(fluid: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(fluid)) ret.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFluid: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "fluid")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptFn0Number(optFn0Number: js.UndefOr[CallbackTo[Double]]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        optFn0Number.foreach(p => ret.updateDynamic("optFn0Number")(p.toJsFn))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOptFn0Number: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "optFn0Number")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptFn0Void(optFn0Void: js.UndefOr[Callback]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        optFn0Void.foreach(p => ret.updateDynamic("optFn0Void")(p.toJsFn))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOptFn0Void: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "optFn0Void")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptFn1Number(optFn1Number: /* x */ Double => CallbackTo[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (optFn1Number != null) ret.updateDynamic("optFn1Number")(js.Any.fromFunction1((t0: /* x */ Double) => optFn1Number(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOptFn1Number: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "optFn1Number")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptFn1Void(optFn1Void: /* x */ Double => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (optFn1Void != null) ret.updateDynamic("optFn1Void")(js.Any.fromFunction1((t0: /* x */ Double) => optFn1Void(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOptFn1Void: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "optFn1Void")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withText(text: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(text)) ret.updateDynamic("text")(text.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutText: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "text")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withTextAlign(textAlign: SemanticTEXTALIGNMENTS): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (textAlign != null) ret.updateDynamic("textAlign")(textAlign.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutTextAlign: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "textAlign")
        ret.asInstanceOf[Self]
    }
  }
  
}

