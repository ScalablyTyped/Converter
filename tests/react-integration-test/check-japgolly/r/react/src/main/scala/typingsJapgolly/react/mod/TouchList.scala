package typingsJapgolly.react.mod

import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.NumberDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait TouchList extends /* index */ NumberDictionary[Touch] {
  var length: Double = js.native
  def identifiedTouch(identifier: Double): Touch = js.native
  def item(index: Double): Touch = js.native
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
    __obj.updateDynamic("identifiedTouch")(js.Any.fromFunction1((t0: Double) => identifiedTouch(t0).runNow()))
    __obj.updateDynamic("item")(js.Any.fromFunction1((t0: Double) => item(t0).runNow()))
    if (NumberDictionary != null) js.Dynamic.global.Object.assign(__obj, NumberDictionary)
    __obj.asInstanceOf[TouchList]
  }
  @scala.inline
  implicit class TouchListOps[Self <: TouchList] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withIdentifiedTouch(identifiedTouch: Double => CallbackTo[Touch]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("identifiedTouch")(js.Any.fromFunction1((t0: Double) => identifiedTouch(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withItem(item: Double => CallbackTo[Touch]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("item")(js.Any.fromFunction1((t0: Double) => item(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLength(length: Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("length")(length.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

