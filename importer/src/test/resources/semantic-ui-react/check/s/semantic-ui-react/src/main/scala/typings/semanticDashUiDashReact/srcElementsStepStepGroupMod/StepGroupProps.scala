package typings.semanticDashUiDashReact.srcElementsStepStepGroupMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.reactMod.ReactNode
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`1`
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`2`
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`3`
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`4`
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`5`
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`6`
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`7`
import typings.semanticDashUiDashReact.semanticDashUiDashReactNumbers.`8`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.big
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.eight
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.five
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.four
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.huge
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.large
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.massive
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.mini
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.one
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.seven
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.six
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.small
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.tablet
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.three
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.tiny
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.two
import typings.semanticDashUiDashReact.srcElementsStepStepMod.StepProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandCollection
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait StepGroupProps
  extends StrictStepGroupProps
     with /* key */ StringDictionary[js.Any]

object StepGroupProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    attached: Boolean | bottom | top = null,
    children: ReactNode = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    items: SemanticShorthandCollection[StepProps] = null,
    ordered: js.UndefOr[Boolean] = js.undefined,
    size: mini | tiny | small | large | big | huge | massive = null,
    stackable: tablet = null,
    unstackable: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    widths: `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`1` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`2` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`3` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`4` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`5` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`6` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`7` | typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`8` | one | two | three | four | five | six | seven | eight = null
  ): StepGroupProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (items != null) __obj.updateDynamic("items")(items)
    if (!js.isUndefined(ordered)) __obj.updateDynamic("ordered")(ordered)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (stackable != null) __obj.updateDynamic("stackable")(stackable)
    if (!js.isUndefined(unstackable)) __obj.updateDynamic("unstackable")(unstackable)
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical)
    if (widths != null) __obj.updateDynamic("widths")(widths.asInstanceOf[js.Any])
    __obj.asInstanceOf[StepGroupProps]
  }
}

