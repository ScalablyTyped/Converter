package typings.reactDashContextmenu.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.ReactComponentClass
import slinky.web.html.`*`.tag
import typings.react.reactMod.HTMLAttributes
import typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTriggerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: id */
object ContextMenuTrigger
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger].asInstanceOf[String | js.Object]
  def apply(
    attributes: HTMLAttributes[_] = null,
    collect: /* data */ js.Any => _ = null,
    disable: js.UndefOr[Boolean] = js.undefined,
    holdToDisplay: Int | Double = null,
    renderTag: ReactComponentClass[_] = null,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, typings.reactDashContextmenu.reactDashContextmenuMod.ContextMenuTrigger] = {
    val __obj = js.Dynamic.literal()
    if (attributes != null) __obj.updateDynamic("attributes")(attributes.asInstanceOf[js.Any])
    if (collect != null) __obj.updateDynamic("collect")(js.Any.fromFunction1(collect))
    if (!js.isUndefined(disable)) __obj.updateDynamic("disable")(disable.asInstanceOf[js.Any])
    if (holdToDisplay != null) __obj.updateDynamic("holdToDisplay")(holdToDisplay.asInstanceOf[js.Any])
    if (renderTag != null) __obj.updateDynamic("renderTag")(renderTag.asInstanceOf[js.Any])
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ContextMenuTriggerProps
}

