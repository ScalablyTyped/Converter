package typings.expressDashServeDashStaticDashCore.expressDashServeDashStaticDashCoreMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Request extends typings.expressDashServeDashStaticDashCore.expressDashServeDashStaticDashCoreMod._Global_.Express.Request {
  var url: String
}

object Request {
  @inline
  def apply(url: String): Request = {
    val __obj = js.Dynamic.literal(url = url)
  
    __obj.asInstanceOf[Request]
  }
}

