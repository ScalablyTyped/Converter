package typings.angular.angularMod

import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

// All service providers extend this interface
trait IServiceProvider extends js.Object {
  @JSName("$get")
  var $get: js.Any
}

object IServiceProvider {
  @inline
  def apply($get: js.Any): IServiceProvider = {
    val __obj = js.Dynamic.literal($get = $get)
  
    __obj.asInstanceOf[IServiceProvider]
  }
}

