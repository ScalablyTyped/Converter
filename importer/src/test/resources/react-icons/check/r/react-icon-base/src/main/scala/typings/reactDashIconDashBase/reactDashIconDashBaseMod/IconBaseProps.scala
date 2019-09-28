package typings.reactDashIconDashBase.reactDashIconDashBaseMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.reactMod.ClassAttributes
import typings.react.reactMod.Key
import typings.react.reactMod.ReactSVGElement
import typings.react.reactMod.Ref
import scala.scalajs.js
import scala.scalajs.js.`|`

trait IconBaseProps extends ClassAttributes[ReactSVGElement] {
  var size: js.UndefOr[String | Double] = js.undefined
}

object IconBaseProps {
  @inline
  def apply(
    hasOwnProperty: String => Boolean,
    isPrototypeOf: js.Object => Boolean,
    propertyIsEnumerable: String => Boolean,
    toLocaleString: () => String,
    valueOf: () => js.Any,
    key: Key = null,
    ref: Ref[ReactSVGElement] = null,
    size: String | Double = null
  ): IconBaseProps = {
    val __obj = js.Dynamic.literal(hasOwnProperty = js.Any.fromFunction1(hasOwnProperty), isPrototypeOf = js.Any.fromFunction1(isPrototypeOf), propertyIsEnumerable = js.Any.fromFunction1(propertyIsEnumerable), toLocaleString = js.Any.fromFunction0(toLocaleString), valueOf = js.Any.fromFunction0(valueOf))
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    __obj.asInstanceOf[IconBaseProps]
  }
}

