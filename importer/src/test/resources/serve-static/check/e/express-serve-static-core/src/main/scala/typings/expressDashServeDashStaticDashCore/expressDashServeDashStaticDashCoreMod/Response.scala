package typings.expressDashServeDashStaticDashCore.expressDashServeDashStaticDashCoreMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Response extends typings.expressDashServeDashStaticDashCore.expressDashServeDashStaticDashCoreMod._Global_.Express.Response {
  def location(url: String): Response
}

object Response {
  @inline
  def apply(location: String => Response): Response = {
    val __obj = js.Dynamic.literal(location = js.Any.fromFunction1(location))
  
    __obj.asInstanceOf[Response]
  }
}

