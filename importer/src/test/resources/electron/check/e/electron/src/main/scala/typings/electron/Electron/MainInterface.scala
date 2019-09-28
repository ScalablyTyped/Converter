package typings.electron.Electron

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait MainInterface extends CommonInterface {
  var app: App
}

object MainInterface {
  @inline
  def apply(app: App): MainInterface = {
    val __obj = js.Dynamic.literal(app = app)
  
    __obj.asInstanceOf[MainInterface]
  }
}

