package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`very long`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`very short`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.full
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.long
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.medium
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.short
import typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderLineMod.PlaceholderLineProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object PlaceholderLine {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    length: full | (`very long`) | long | medium | short | (`very short`) = null
  ): UnmountedSimple[
    PlaceholderLineProps, 
    MountedWithRawType[PlaceholderLineProps, js.Object, RawMounted[PlaceholderLineProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (length != null) __obj.updateDynamic("length")(length.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderLineMod.PlaceholderLineProps, 
  japgolly.scalajs.react.Children.None, 
  js.Object](typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderLineMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderLineMod.PlaceholderLineProps])
  }
}

