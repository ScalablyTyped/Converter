package typings.vueDashResource.vuejs

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait VueStatic extends js.Object {
  var http: Http
  var resource: Resource
}

object VueStatic {
  @inline
  def apply(http: Http, resource: Resource): VueStatic = {
    val __obj = js.Dynamic.literal(http = http, resource = resource)
  
    __obj.asInstanceOf[VueStatic]
  }
}

