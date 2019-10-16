package typings.semanticUiReact.elementsStepStepMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.elementsStepStepContentMod.StepContentProps
import typings.semanticUiReact.elementsStepStepDescriptionMod.StepDescriptionProps
import typings.semanticUiReact.elementsStepStepGroupMod.StepGroupProps
import typings.semanticUiReact.elementsStepStepTitleMod.StepTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StepComponent extends ComponentClass[StepProps, ComponentState] {
  var Content: StatelessComponent[StepContentProps] = js.native
  var Description: StatelessComponent[StepDescriptionProps] = js.native
  var Group: StatelessComponent[StepGroupProps] = js.native
  var Title: StatelessComponent[StepTitleProps] = js.native
}

