package typings.semanticUiReact.jagpolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsStepStepContentMod.StepContentProps
import typings.semanticUiReact.elementsStepStepDescriptionMod.StepDescriptionProps
import typings.semanticUiReact.elementsStepStepTitleMod.StepTitleProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object StepContent {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    description: SemanticShorthandItem[StepDescriptionProps] = null,
    title: SemanticShorthandItem[StepTitleProps] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    StepContentProps, 
    MountedWithRawType[StepContentProps, js.Object, RawMounted[StepContentProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description.asInstanceOf[js.Any])
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsStepStepContentMod.StepContentProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsStepStepContentMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsStepStepContentMod.StepContentProps])(children: _*)
  }
}

