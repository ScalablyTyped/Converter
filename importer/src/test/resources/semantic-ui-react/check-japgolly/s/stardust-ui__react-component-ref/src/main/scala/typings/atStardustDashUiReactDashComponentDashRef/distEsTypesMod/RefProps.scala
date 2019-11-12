package typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod

import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Ref
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait RefProps extends js.Object {
  var children: Element
  /**
    * Called when a child component will be mounted or updated.
    *
    * @param {HTMLElement} node - Referred node.
    */
  var innerRef: Ref
}

object RefProps {
  @scala.inline
  def apply(children: Element, innerRef: Ref = null): RefProps = {
    val __obj = js.Dynamic.literal(children = children)
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[RefProps]
  }
}

