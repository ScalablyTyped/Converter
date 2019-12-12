package typingsSlinky.reactContextmenu.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.ReactComponentClass
import slinky.web.html.`*`.tag
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.reactContextmenu.mod.ContextMenuTrigger
import typingsSlinky.reactContextmenu.mod.ContextMenuTriggerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ModContextMenuTrigger {
  object raw
    extends ExternalComponentWithAttributesWithRefType[tag.type, ContextMenuTrigger] {
    @JSImport("react-contextmenu", "ContextMenuTrigger")
    @js.native
    object componentImport extends js.Object
    
    override val component: String | js.Object = this.componentImport
    type Props = ContextMenuTriggerProps
  }
  
  /* The following DOM/SVG props were specified: id */
  def apply(
    attributes: HTMLAttributes[_] = null,
    collect: /* data */ js.Any => _ = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactComponentClass[_] = null,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, ContextMenuTrigger] = {
    val __obj = js.Dynamic.literal()
    if (attributes != null) __obj.updateDynamic("attributes")(attributes.asInstanceOf[js.Any])
    if (collect != null) __obj.updateDynamic("collect")(js.Any.fromFunction1(collect))
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable.asInstanceOf[js.Any])
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

