package typingsSlinky.semanticUiReact.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.ExternalPropsWriterProvider
import slinky.web.html.`*`.tag
import typingsSlinky.semanticUiReact.mod.dist.commonjs.elements.Button.ButtonContent.ButtonContentProps
import typingsSlinky.semanticUiReact.mod.dist.commonjs.generic.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_ButtonContentProps_1433057184 () {
  abstract class Raw (implicit pw: ExternalPropsWriterProvider)
    extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
    type Props = ButtonContentProps
  }
  
  val raw: Raw
  /* The following DOM/SVG props were specified: className, hidden */
  def apply(
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    visible: js.UndefOr[Boolean] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal()
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

