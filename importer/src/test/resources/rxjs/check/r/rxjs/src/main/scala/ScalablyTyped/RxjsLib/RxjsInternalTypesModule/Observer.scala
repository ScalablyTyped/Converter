package ScalablyTyped
package RxjsLib.RxjsInternalTypesModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait Observer[T] extends js.Object {
  val closed: js.UndefOr[scala.Boolean] = js.undefined
  def complete(): scala.Unit
  def error(err: js.Any): scala.Unit
  def next(value: T): scala.Unit
}

