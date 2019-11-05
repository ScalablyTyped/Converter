package typings.semanticUiReact.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.modulesAccordionAccordionContentMod.AccordionContentProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object AccordionContent {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    key: js.UndefOr[Key] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedSimple[
    AccordionContentProps, 
    MountedWithRawType[AccordionContentProps, js.Object, RawMounted[AccordionContentProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.modulesAccordionAccordionContentMod.AccordionContentProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.modulesAccordionAccordionContentMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesAccordionAccordionContentMod.AccordionContentProps])(children: _*)
  }
}

