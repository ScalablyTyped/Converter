package ScalablyTyped
package VueDashResourceLib.vuejsNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait HttpResponse extends js.Object {
  var data: js.Object
  var headers: js.Function
  var ok: scala.Boolean
  var status: scala.Double
  var statusText: java.lang.String
  def blob(): StdLib.Blob
  def json(): js.Any
  def text(): java.lang.String
}

