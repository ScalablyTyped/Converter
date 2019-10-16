package typings.semanticUiReact.elementsLabelLabelMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.elementsLabelLabelDetailMod.LabelDetailProps
import typings.semanticUiReact.elementsLabelLabelGroupMod.LabelGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait LabelComponent extends ComponentClass[LabelProps, ComponentState] {
  var Detail: StatelessComponent[LabelDetailProps] = js.native
  var Group: StatelessComponent[LabelGroupProps] = js.native
}

