package ScalablyTyped
package ElectronLib.ElectronNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait App extends EventEmitter {
  // Docs: http://electron.atom.io/docs/api/app
  /**
       * Emitted when Chrome's accessibility support changes. This event fires when
       * assistive technologies, such as screen readers, are enabled or disabled. See
       * https://www.chromium.org/developers/design-documents/accessibility for more
       * details.
       */
  @JSName("on")
  def `on_accessibility-support-changed`(event: ElectronLib.ElectronLibStrings.`accessibility-support-changed`, listener: js.Any): java.lang.String = js.native
}

