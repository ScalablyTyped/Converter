package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.elementsButtonButtonContentMod.ButtonContentProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, hidden */
object Content {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    content: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticShorthandContent */ js.Any = null,
    visible: js.UndefOr[Boolean] = js.undefined
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[ButtonContentProps, js.Object, Unit, ButtonContentProps] = {
    import japgolly.scalajs.react._
  
    val __obj = js.Dynamic.literal()
  
    type ContentType = scala.scalajs.js.Object
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content)
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, ContentType](js.constructorOf[ContentType])
  
    f(props)(children: _*)
  }
  type Props = ButtonContentProps
}

