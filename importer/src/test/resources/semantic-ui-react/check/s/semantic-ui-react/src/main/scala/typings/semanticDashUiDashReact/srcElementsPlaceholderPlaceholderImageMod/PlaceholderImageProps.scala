package typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderImageMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait PlaceholderImageProps
  extends StrictPlaceholderImageProps
     with /* key */ StringDictionary[js.Any]

object PlaceholderImageProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    rectangular: js.UndefOr[Boolean] = js.undefined,
    square: js.UndefOr[Boolean] = js.undefined
  ): PlaceholderImageProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(rectangular)) __obj.updateDynamic("rectangular")(rectangular)
    if (!js.isUndefined(square)) __obj.updateDynamic("square")(square)
    __obj.asInstanceOf[PlaceholderImageProps]
  }
}

