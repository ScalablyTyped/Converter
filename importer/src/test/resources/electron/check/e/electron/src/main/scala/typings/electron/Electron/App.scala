package typings.electron.Electron

import org.scalablytyped.runtime.TopLevel
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.annotation.JSName
import typings.electron.electronStrings.`accessibility-support-changed`
import scala.scalajs.js
import scala.scalajs.js.`|`

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
  def on_accessibilitysupportchanged(event: `accessibility-support-changed`, listener: js.Any): String = js.native
}

@JSGlobal("Electron.app")
@js.native
object app extends TopLevel[App]

