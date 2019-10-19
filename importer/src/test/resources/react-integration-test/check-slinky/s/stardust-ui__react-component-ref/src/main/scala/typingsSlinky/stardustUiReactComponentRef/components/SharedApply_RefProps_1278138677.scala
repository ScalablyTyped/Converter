package typingsSlinky.stardustUiReactComponentRef.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.ExternalPropsWriterProvider
import slinky.web.html.`*`.tag
import typingsSlinky.react.mod.Ref
import typingsSlinky.stardustUiReactComponentRef.mod.dist.es.types.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_RefProps_1278138677[ComponentRef <: js.Object] () {
  abstract class Raw (implicit pw: ExternalPropsWriterProvider)
    extends ExternalComponentWithAttributesWithRefType[tag.type, ComponentRef] {
    type Props = RefProps
  }
  
  val raw: Raw
  def apply(innerRef: Ref[_] = null, _overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, ComponentRef] = {
    val __obj = js.Dynamic.literal()
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

