package typings.electron.Electron

import typings.electron.electronStrings.`accessibility-support-changed`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait App_ extends EventEmitter {
  // Docs: http://electron.atom.io/docs/api/app
  /**
    * Emitted when Chrome's accessibility support changes. This event fires when
    * assistive technologies, such as screen readers, are enabled or disabled. See
    * https://www.chromium.org/developers/design-documents/accessibility for more
    * details.
    */
  @JSName("on")
  def on_accessibilitysupportchanged(event: `accessibility-support-changed`, listener: js.Any): String = js.native
}

