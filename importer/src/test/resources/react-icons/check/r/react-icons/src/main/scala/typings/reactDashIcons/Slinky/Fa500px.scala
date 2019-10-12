package typings.reactDashIcons.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Fa500px
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactDashIcons.faMod.Fa500px] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashIcons.faMod.Fa500px].asInstanceOf[String | js.Object]
  type dummy = typings.reactDashIcons.faMod.Fa500px
  def apply(size: String | Double = null): BuildingComponent[tag.type, typings.reactDashIcons.faMod.Fa500px] = {
    val __obj = js.Dynamic.literal()
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = IconBaseProps
}

