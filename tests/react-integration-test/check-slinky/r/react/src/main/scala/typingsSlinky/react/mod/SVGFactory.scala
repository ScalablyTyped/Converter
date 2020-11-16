package typingsSlinky.react.mod

import org.scalajs.dom.raw.SVGElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait SVGFactory extends DOMFactory[SVGAttributes[SVGElement], SVGElement] {
  
  def apply(
    props: ClassAttributes[SVGElement] with SVGAttributes[SVGElement],
    children: slinky.core.facade.ReactElement*
  ): ReactSVGElement = js.native
  def apply(props: js.UndefOr[scala.Nothing], children: slinky.core.facade.ReactElement*): ReactSVGElement = js.native
  def apply(props: Null, children: slinky.core.facade.ReactElement*): ReactSVGElement = js.native
}
