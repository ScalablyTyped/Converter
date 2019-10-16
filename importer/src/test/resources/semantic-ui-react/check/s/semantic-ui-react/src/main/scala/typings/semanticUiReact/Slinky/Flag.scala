package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.semanticUiReact.elementsFlagFlagMod.FlagNameValues
import typings.semanticUiReact.elementsFlagFlagMod.FlagProps
import typings.semanticUiReact.elementsFlagMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className */
object Flag
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticUiReact.elementsFlagMod.default].asInstanceOf[String | js.Object]
  def apply(
    name: FlagNameValues,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal(name = name)
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = FlagProps
}

