package typings.reactSelect

import typings.react.reactMod.ComponentType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object reactSelectComponents extends reactSelectProps {
  @scala.inline
  def ReactSelect[TValue]: ComponentType[ReactSelectProps[TValue]] = js.constructorOf[typings.reactSelect.reactSelectMod.default[TValue]].asInstanceOf[typings.react.reactMod.ComponentType[ReactSelectProps[TValue]]]
}

