package typings.reactDashSelect.reactDashSelectMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.reactMod.Props
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ReactSelectProps[TValue] extends Props[ReactSelectClass[TValue]] {
  /**
    * text to display when `allowCreate` is true.
    * @default 'Add "{label}"?'
    */
  var addLabelText: js.UndefOr[String] = js.undefined
}

object ReactSelectProps {
  @inline
  def apply[TValue](
    hasOwnProperty: String => Boolean,
    isPrototypeOf: js.Object => Boolean,
    propertyIsEnumerable: String => Boolean,
    toLocaleString: () => String,
    valueOf: () => js.Any,
    addLabelText: String = null,
    key: String = null
  ): ReactSelectProps[TValue] = {
    val __obj = js.Dynamic.literal(hasOwnProperty = js.Any.fromFunction1(hasOwnProperty), isPrototypeOf = js.Any.fromFunction1(isPrototypeOf), propertyIsEnumerable = js.Any.fromFunction1(propertyIsEnumerable), toLocaleString = js.Any.fromFunction0(toLocaleString), valueOf = js.Any.fromFunction0(valueOf))
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
    if (key != null) __obj.updateDynamic("key")(key)
    __obj.asInstanceOf[ReactSelectProps[TValue]]
  }
}

