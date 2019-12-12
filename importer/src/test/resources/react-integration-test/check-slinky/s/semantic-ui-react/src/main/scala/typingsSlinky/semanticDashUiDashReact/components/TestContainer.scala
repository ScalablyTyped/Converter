package typingsSlinky.semanticDashUiDashReact.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.semanticDashUiDashReact.distCommonjsElementsTestContainerTestContainerMod.TestContainerProps
import typingsSlinky.semanticDashUiDashReact.distCommonjsGenericMod.SemanticShorthandContent
import typingsSlinky.semanticDashUiDashReact.distCommonjsGenericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object TestContainer {
  object raw
    extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
    @JSImport("semantic-ui-react/dist/commonjs/elements/TestContainer", JSImport.Default)
    @js.native
    object componentImport extends js.Object
    
    override val component: String | js.Object = this.componentImport
    type Props = TestContainerProps
  }
  
  /* The following DOM/SVG props were specified: className */
  def apply(
    requiredFn0Number: () => Double,
    requiredFn0Void: () => Unit,
    requiredFn1Number: Double => Double,
    requiredFn1Void: Double => Unit,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    optFn0Number: () => Double = null,
    optFn0Void: () => Unit = null,
    optFn1Number: /* x */ Double => Double = null,
    optFn1Void: /* x */ Double => Unit = null,
    text: js.UndefOr[Boolean] = js.undefined,
    textAlign: SemanticTEXTALIGNMENTS = null,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal(requiredFn0Number = js.Any.fromFunction0(requiredFn0Number), requiredFn0Void = js.Any.fromFunction0(requiredFn0Void), requiredFn1Number = js.Any.fromFunction1(requiredFn1Number), requiredFn1Void = js.Any.fromFunction1(requiredFn1Void))
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
    if (optFn0Number != null) __obj.updateDynamic("optFn0Number")(js.Any.fromFunction0(optFn0Number))
    if (optFn0Void != null) __obj.updateDynamic("optFn0Void")(js.Any.fromFunction0(optFn0Void))
    if (optFn1Number != null) __obj.updateDynamic("optFn1Number")(js.Any.fromFunction1(optFn1Number))
    if (optFn1Void != null) __obj.updateDynamic("optFn1Void")(js.Any.fromFunction1(optFn1Void))
    if (!js.isUndefined(text)) __obj.updateDynamic("text")(text.asInstanceOf[js.Any])
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

