package typings.reactDashIcons.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object FaAdn
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactDashIcons.faMod.FaAdn] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashIcons.faMod.FaAdn].asInstanceOf[String | js.Object]
  def apply(size: String | Double = null): BuildingComponent[tag.type, typings.reactDashIcons.faMod.FaAdn] = {
    val __obj = js.Dynamic.literal()
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = IconBaseProps
}

