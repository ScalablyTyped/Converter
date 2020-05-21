package typings.electron.Electron

import typings.electron.electronStrings.`accessibility-support-changed`
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
  def on_accessibilitysupportchanged(event: `accessibility-support-changed`, listener: js.Any): String = js.native
}

object App {
  @scala.inline
  def apply(addListener: (String, js.Function) => App, on: (`accessibility-support-changed`, js.Any) => String): App = {
    val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener), on = js.Any.fromFunction2(on))
    __obj.asInstanceOf[App]
  }
  @scala.inline
  implicit class AppOps[Self <: App] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setOn(value: (`accessibility-support-changed`, js.Any) => String): Self = this.set("on", js.Any.fromFunction2(value))
  }
  
}

