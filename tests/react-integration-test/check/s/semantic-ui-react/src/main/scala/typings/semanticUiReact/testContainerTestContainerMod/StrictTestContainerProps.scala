package typings.semanticUiReact.testContainerTestContainerMod

import typings.react.mod.ReactNode
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictTestContainerProps extends js.Object {
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** Primary content. */
  var children: js.UndefOr[ReactNode] = js.native
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
    requiredFn0Number: () => Double,
    requiredFn0Void: () => Unit,
    requiredFn1Number: Double => Double,
    requiredFn1Void: Double => Unit,
    as: js.Any = null,
    children: ReactNode = null,
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
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
    if (optFn0Number != null) __obj.updateDynamic("optFn0Number")(js.Any.fromFunction0(optFn0Number))
    if (optFn0Void != null) __obj.updateDynamic("optFn0Void")(js.Any.fromFunction0(optFn0Void))
    if (optFn1Number != null) __obj.updateDynamic("optFn1Number")(js.Any.fromFunction1(optFn1Number))
    if (optFn1Void != null) __obj.updateDynamic("optFn1Void")(js.Any.fromFunction1(optFn1Void))
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
    def withRequiredFn0Number(requiredFn0Number: () => Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn0Number")(js.Any.fromFunction0(requiredFn0Number))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRequiredFn0Void(requiredFn0Void: () => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn0Void")(js.Any.fromFunction0(requiredFn0Void))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRequiredFn1Number(requiredFn1Number: Double => Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn1Number")(js.Any.fromFunction1(requiredFn1Number))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRequiredFn1Void(requiredFn1Void: Double => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("requiredFn1Void")(js.Any.fromFunction1(requiredFn1Void))
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
    def withChildren(children: ReactNode): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.asInstanceOf[js.Any])
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
    def withOptFn0Number(optFn0Number: () => Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (optFn0Number != null) ret.updateDynamic("optFn0Number")(js.Any.fromFunction0(optFn0Number))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOptFn0Number: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "optFn0Number")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptFn0Void(optFn0Void: () => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (optFn0Void != null) ret.updateDynamic("optFn0Void")(js.Any.fromFunction0(optFn0Void))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOptFn0Void: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "optFn0Void")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptFn1Number(optFn1Number: /* x */ Double => Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (optFn1Number != null) ret.updateDynamic("optFn1Number")(js.Any.fromFunction1(optFn1Number))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOptFn1Number: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "optFn1Number")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOptFn1Void(optFn1Void: /* x */ Double => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (optFn1Void != null) ret.updateDynamic("optFn1Void")(js.Any.fromFunction1(optFn1Void))
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

