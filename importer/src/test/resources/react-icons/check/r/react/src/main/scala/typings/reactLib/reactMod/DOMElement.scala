package typings
package reactLib.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// string fallback for custom web-components
trait DOMElement[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: reactLib.Element */] extends ReactElement[P] {
  var ref: Ref[T]
  @JSName("type")
  var type_DOMElement: java.lang.String
}

object DOMElement {
  @scala.inline
  def apply[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: reactLib.Element */](props: P, ref: Ref[T], `type`: java.lang.String, key: Key = null): DOMElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], ref = ref.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`)
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[DOMElement[P, T]]
  }
}

