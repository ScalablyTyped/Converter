package typings.electron.Electron

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait MainInterface extends CommonInterface {
  var app: App
}

object MainInterface {
  @scala.inline
  def apply(app: App): MainInterface = {
    val __obj = js.Dynamic.literal(app = app.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[MainInterface]
  }
}

