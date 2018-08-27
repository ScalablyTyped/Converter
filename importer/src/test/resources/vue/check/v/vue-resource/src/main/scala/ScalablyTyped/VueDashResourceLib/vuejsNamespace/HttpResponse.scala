package ScalablyTyped
package VueDashResourceLib.vuejsNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait HttpResponse extends js.Object {
  val data: js.Object
  val headers: js.Function
  val ok: scala.Boolean
  val status: scala.Double
  val statusText: java.lang.String
  def blob(): StdLib.Blob
  def json(): js.Any
  def text(): java.lang.String
}

