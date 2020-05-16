package typingsSlinky.semanticUiReact.accordionTitleMod

import org.scalajs.dom.raw.HTMLDivElement
import slinky.core.ReactComponentClass
import slinky.core.TagMod
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandContent
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictAccordionTitleProps extends js.Object {
  /** Whether or not the title is in the open state. */
  var active: js.UndefOr[Boolean] = js.native
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** Primary content. */
  var children: js.UndefOr[TagMod[Any]] = js.native
  /** Additional classes. */
  var className: js.UndefOr[String] = js.native
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.native
  /** Shorthand for Icon. */
  var icon: js.UndefOr[
    SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
    ]
  ] = js.native
  /** AccordionTitle index inside Accordion. */
  var index: js.UndefOr[Double | String] = js.native
  /**
    * Called on click.
    *
    * @param {SyntheticEvent} event - React's original SyntheticEvent.
    * @param {object} data - All props.
    */
  var onClick: js.UndefOr[
    js.Function2[
      /* event */ SyntheticMouseEvent[HTMLDivElement], 
      /* data */ AccordionTitleProps, 
      Unit
    ]
  ] = js.native
}

object StrictAccordionTitleProps {
  @scala.inline
  def apply(
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    children: TagMod[Any] = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    icon: SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
    ] = null,
    index: Double | String = null,
    onClick: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit = null
  ): StrictAccordionTitleProps = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    __obj.asInstanceOf[StrictAccordionTitleProps]
  }
  @scala.inline
  implicit class StrictAccordionTitlePropsOps[Self <: StrictAccordionTitleProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withActive(active: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(active)) ret.updateDynamic("active")(active.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutActive: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "active")
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
    def withChildren(children: TagMod[Any]): Self = {
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
    def withIconFunction3(
      icon: (/* component */ ReactComponentClass[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
        ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("icon")(js.Any.fromFunction3(icon))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIcon(
      icon: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
        ]
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (icon != null) ret.updateDynamic("icon")(icon.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutIcon: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "icon")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIndex(index: Double | String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (index != null) ret.updateDynamic("index")(index.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutIndex: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "index")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnClick(onClick: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onClick != null) ret.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnClick: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onClick")
        ret.asInstanceOf[Self]
    }
  }
  
}

