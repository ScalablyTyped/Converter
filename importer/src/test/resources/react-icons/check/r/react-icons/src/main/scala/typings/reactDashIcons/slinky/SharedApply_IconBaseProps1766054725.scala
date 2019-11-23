package typings.reactDashIcons.slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.ExternalPropsWriterProvider
import slinky.web.html.`*`.tag
import typings.reactDashIconDashBase.reactDashIconDashBaseMod.IconBaseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_IconBaseProps1766054725[ComponentRef <: js.Object] (implicit pw: ExternalPropsWriterProvider)
  extends ExternalComponentWithAttributesWithRefType[tag.type, ComponentRef] {
  def apply(size: String | Double = null): BuildingComponent[tag.type, ComponentRef] = {
    val __obj = js.Dynamic.literal()
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = IconBaseProps
}

