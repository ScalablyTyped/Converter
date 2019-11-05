package typings.atStardustUiReactComponentRef.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.atStardustUiReactComponentRef.esRefFindNodeMod.default
import typings.atStardustUiReactComponentRef.esTypesMod.RefProps
import typings.react.reactMod.Ref
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object RefFindNode
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.atStardustUiReactComponentRef.esRefFindNodeMod.default].asInstanceOf[String | js.Object]
  def apply(innerRef: Ref[js.Any] = null): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = RefProps
}

