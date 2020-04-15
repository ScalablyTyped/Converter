package typings.reactSelect

import typings.react.mod.ComponentType
import typings.reactSelect.mod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object reactSelectComponents extends reactSelectProps {
  @scala.inline
  def ReactSelect[TValue]: ComponentType[ReactSelectProps[TValue]] = js.constructorOf[default[TValue]].asInstanceOf[ComponentType[ReactSelectProps[TValue]]]
}

