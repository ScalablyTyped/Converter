package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.NumberDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait TouchList extends /* index */ NumberDictionary[Touch] {
  var length: Double
  def identifiedTouch(identifier: Double): Touch
  def item(index: Double): Touch
}

object TouchList {
  @scala.inline
  def apply(
    identifiedTouch: Double => CallbackTo[Touch],
    item: Double => CallbackTo[Touch],
    length: Double,
    NumberDictionary: /* index */ NumberDictionary[Touch] = null
  ): TouchList = {
    val __obj = js.Dynamic.literal(length = length.asInstanceOf[js.Any])
    __obj.updateDynamic("identifiedTouch")(js.Any.fromFunction1((t0: scala.Double) => identifiedTouch(t0).runNow()))
    __obj.updateDynamic("item")(js.Any.fromFunction1((t0: scala.Double) => item(t0).runNow()))
    if (NumberDictionary != null) js.Dynamic.global.Object.assign(__obj, NumberDictionary)
    __obj.asInstanceOf[TouchList]
  }
}

