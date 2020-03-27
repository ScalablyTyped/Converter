package typings.reactSelect

import typings.react.mod.ComponentType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object reactSelectComponents extends reactSelectProps {
  @scala.inline
  def ReactSelect[TValue]: ComponentType[ReactSelectProps[TValue]] = js.constructorOf[typings.reactSelect.mod.default[TValue]].asInstanceOf[typings.react.mod.ComponentType[ReactSelectProps[TValue]]]
}

