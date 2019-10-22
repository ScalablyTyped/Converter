package typings.semanticUiReact.jagpolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.modulesDimmerDimmerDimmableMod.DimmerDimmableProps
import typings.semanticUiReact.modulesDimmerDimmerDimmableMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object DimmerDimmable {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    blurring: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    content: SemanticShorthandContent = null,
    dimmed: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[DimmerDimmableProps, default, Unit, DimmerDimmableProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(blurring)) __obj.updateDynamic("blurring")(blurring)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(dimmed)) __obj.updateDynamic("dimmed")(dimmed)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesDimmerDimmerDimmableMod.DimmerDimmableProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesDimmerDimmerDimmableMod.default](js.constructorOf[typings.semanticUiReact.modulesDimmerDimmerDimmableMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesDimmerDimmerDimmableMod.DimmerDimmableProps])(children: _*)
  }
}

