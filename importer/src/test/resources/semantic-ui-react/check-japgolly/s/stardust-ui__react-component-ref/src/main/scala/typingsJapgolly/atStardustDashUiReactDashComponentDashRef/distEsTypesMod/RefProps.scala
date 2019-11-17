package typingsJapgolly.atStardustDashUiReactDashComponentDashRef.distEsTypesMod

import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Ref
import japgolly.scalajs.react.vdom.VdomElement
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
  def apply(children: VdomElement, innerRef: Ref): RefProps = {
    val __obj = js.Dynamic.literal(innerRef = innerRef.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawElement.asInstanceOf[js.Any])
    __obj.asInstanceOf[RefProps]
  }
}

