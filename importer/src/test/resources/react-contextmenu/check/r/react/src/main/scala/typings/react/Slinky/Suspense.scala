package typings.react.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.reactMod.SuspenseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children */
object Suspense
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  override val component: String | js.Object = typings.react.reactMod.Suspense.asInstanceOf[String | js.Object]
  def apply(
    fallback: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any = null
  ): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal()
    if (fallback != null) __obj.updateDynamic("fallback")(fallback)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = SuspenseProps
}

