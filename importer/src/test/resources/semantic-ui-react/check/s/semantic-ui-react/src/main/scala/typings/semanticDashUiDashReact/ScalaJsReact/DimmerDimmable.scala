package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesDimmerDimmerDimmableMod.DimmerDimmableProps
import typings.semanticDashUiDashReact.srcModulesDimmerDimmerDimmableMod.default
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
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesDimmerDimmerDimmableMod.DimmerDimmableProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesDimmerDimmerDimmableMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesDimmerDimmerDimmableMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesDimmerDimmerDimmableMod.DimmerDimmableProps])(children: _*)
  }
}

