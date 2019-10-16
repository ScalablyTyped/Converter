package typings.reactIcons.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.reactIconBase.reactIconBaseMod.IconBaseProps
import typings.reactIcons.faAdnMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Adn
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.reactIcons.faAdnMod.default].asInstanceOf[String | js.Object]
  def apply(size: String | Double = null): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = IconBaseProps
}

