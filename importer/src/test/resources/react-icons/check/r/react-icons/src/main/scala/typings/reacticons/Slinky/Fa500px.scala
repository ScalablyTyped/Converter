package typings.reactIcons.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.reactIconBase.reactIconBaseMod.IconBaseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Fa500px
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactIcons.faMod.Fa500px] {
  override val component: String | js.Object = js.constructorOf[typings.reactIcons.faMod.Fa500px].asInstanceOf[String | js.Object]
  def apply(size: String | Double = null): BuildingComponent[tag.type, typings.reactIcons.faMod.Fa500px] = {
    val __obj = js.Dynamic.literal()
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = IconBaseProps
}

