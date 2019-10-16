package typings.reactIcons.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.reactIconBase.reactIconBaseMod.IconBaseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object FaAdjust
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactIcons.faMod.FaAdjust] {
  override val component: String | js.Object = js.constructorOf[typings.reactIcons.faMod.FaAdjust].asInstanceOf[String | js.Object]
  def apply(size: String | Double = null): BuildingComponent[tag.type, typings.reactIcons.faMod.FaAdjust] = {
    val __obj = js.Dynamic.literal()
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = IconBaseProps
}

