package typings.electron.Electron

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Event extends typings.std.Event {
  var altKey: js.UndefOr[Boolean] = js.undefined
  var ctrlKey: js.UndefOr[Boolean] = js.undefined
  var metaKey: js.UndefOr[Boolean] = js.undefined
  var returnValue: js.Any
  var shiftKey: js.UndefOr[Boolean] = js.undefined
  def preventDefault(): Unit
}

object Event {
  @inline
  def apply(
    hasOwnProperty: String => Boolean,
    isPrototypeOf: js.Object => Boolean,
    preventDefault: () => Unit,
    propertyIsEnumerable: String => Boolean,
    returnValue: js.Any,
    toLocaleString: () => String,
    valueOf: () => js.Any,
    altKey: js.UndefOr[Boolean] = js.undefined,
    ctrlKey: js.UndefOr[Boolean] = js.undefined,
    metaKey: js.UndefOr[Boolean] = js.undefined,
    shiftKey: js.UndefOr[Boolean] = js.undefined
  ): Event = {
    val __obj = js.Dynamic.literal(hasOwnProperty = js.Any.fromFunction1(hasOwnProperty), isPrototypeOf = js.Any.fromFunction1(isPrototypeOf), preventDefault = js.Any.fromFunction0(preventDefault), propertyIsEnumerable = js.Any.fromFunction1(propertyIsEnumerable), returnValue = returnValue, toLocaleString = js.Any.fromFunction0(toLocaleString), valueOf = js.Any.fromFunction0(valueOf))
    if (!js.isUndefined(altKey)) __obj.updateDynamic("altKey")(altKey)
    if (!js.isUndefined(ctrlKey)) __obj.updateDynamic("ctrlKey")(ctrlKey)
    if (!js.isUndefined(metaKey)) __obj.updateDynamic("metaKey")(metaKey)
    if (!js.isUndefined(shiftKey)) __obj.updateDynamic("shiftKey")(shiftKey)
    __obj.asInstanceOf[Event]
  }
}

