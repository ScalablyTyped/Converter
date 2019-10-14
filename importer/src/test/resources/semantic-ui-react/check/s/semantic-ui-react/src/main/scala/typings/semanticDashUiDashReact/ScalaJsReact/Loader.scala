package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.centered
import typings.semanticDashUiDashReact.srcElementsLoaderLoaderMod.LoaderProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticSIZES
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, disabled */
object Loader {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    indeterminate: js.UndefOr[Boolean] = js.undefined,
    `inline`: Boolean | centered = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    size: SemanticSIZES = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedSimple[
    LoaderProps, 
    MountedWithRawType[LoaderProps, js.Object, RawMounted[LoaderProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(indeterminate)) __obj.updateDynamic("indeterminate")(indeterminate)
    if (`inline` != null) __obj.updateDynamic("inline")(`inline`.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (size != null) __obj.updateDynamic("size")(size)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsLoaderLoaderMod.LoaderProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcElementsLoaderMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsLoaderLoaderMod.LoaderProps])(children: _*)
  }
}

