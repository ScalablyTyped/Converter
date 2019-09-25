package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
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

/* The following DOM/SVG props were specified: className */
object PlaceholderLine {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    length: full | (`very long`) | long | medium | short | (`very short`) = null
  )(
    
  ): UnmountedWithRoot[PlaceholderLineProps, js.Object, Unit, PlaceholderLineProps] = {
    import japgolly.scalajs.react._
  
    val __obj = js.Dynamic.literal()
  
    type PlaceholderLineType = scala.scalajs.js.Object
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (length != null) __obj.updateDynamic("length")(length.asInstanceOf[js.Any])
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, PlaceholderLineType](js.constructorOf[PlaceholderLineType])
  
    f(props)
  }
  type Props = PlaceholderLineProps
}

