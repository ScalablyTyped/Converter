package typings.electron.Electron

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait MainInterface extends CommonInterface {
  var app: App_ = js.native
}

object MainInterface {
  @scala.inline
  def apply(app: App_): MainInterface = {
    val __obj = js.Dynamic.literal(app = app.asInstanceOf[js.Any])
    __obj.asInstanceOf[MainInterface]
  }
}

