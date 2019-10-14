package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesModalModalContentMod.ModalContentProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className */
object ModalContent {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    image: js.UndefOr[Boolean] = js.undefined,
    scrolling: js.UndefOr[Boolean] = js.undefined
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[ModalContentProps, js.Object, Unit, ModalContentProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type ModalContentType = scala.scalajs.js.Object
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(image)) __obj.updateDynamic("image")(image)
    if (!js.isUndefined(scrolling)) __obj.updateDynamic("scrolling")(scrolling)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, ModalContentType](js.constructorOf[ModalContentType])
  
    f(props)(children: _*)
  }
  type Props = ModalContentProps
}

