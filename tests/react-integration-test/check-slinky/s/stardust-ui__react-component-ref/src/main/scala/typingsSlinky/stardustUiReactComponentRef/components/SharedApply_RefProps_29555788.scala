package typingsSlinky.stardustUiReactComponentRef.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.ExternalPropsWriterProvider
import slinky.core.TagMod
import slinky.web.html.`*`.tag
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_RefProps_29555788[ComponentRef <: js.Object] (implicit pw: ExternalPropsWriterProvider)
  extends ExternalComponentWithAttributesWithRefType[tag.type, ComponentRef] {
  def apply(innerRef: typingsSlinky.react.mod.Ref[_] = null, _overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, ComponentRef] = {
    val __obj = js.Dynamic.literal()
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  def apply(mods: TagMod[tag.type]*): BuildingComponent[tag.type, ComponentRef] = new slinky.core.BuildingComponent[slinky.web.html.`*`.tag.type, ComponentRef](js.Array(component.asInstanceOf[js.Any], js.Dictionary.empty)).apply(mods: _*)
  type Props = RefProps
}

