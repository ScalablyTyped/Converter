package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcElementsListListContentMod.ListContentProps
import typings.semanticDashUiDashReact.srcElementsListListDescriptionMod.ListDescriptionProps
import typings.semanticDashUiDashReact.srcElementsListListHeaderMod.ListHeaderProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcGenericMod.SemanticVERTICALALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className */
object ListContent {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    description: SemanticShorthandItem[ListDescriptionProps] = null,
    floated: SemanticFLOATS = null,
    header: SemanticShorthandItem[ListHeaderProps] = null,
    verticalAlign: SemanticVERTICALALIGNMENTS = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedSimple[
    ListContentProps, 
    MountedWithRawType[ListContentProps, js.Object, RawMounted[ListContentProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (description != null) __obj.updateDynamic("description")(description.asInstanceOf[js.Any])
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (header != null) __obj.updateDynamic("header")(header.asInstanceOf[js.Any])
    if (verticalAlign != null) __obj.updateDynamic("verticalAlign")(verticalAlign)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsListListContentMod.ListContentProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcElementsListListContentMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsListListContentMod.ListContentProps])(children: _*)
  }
}

