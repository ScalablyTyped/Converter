package typings.semanticUiReact.modulesAccordionAccordionMod

import japgolly.scalajs.react.raw.React.ComponentClassP
import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.modulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typings.semanticUiReact.modulesAccordionAccordionContentMod.AccordionContentProps
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AccordionComponent extends ComponentClass[AccordionProps, ComponentState] {
  var Accordion: ComponentClassP[AccordionAccordionProps with js.Object] = js.native
  var Content: StatelessComponent[AccordionContentProps] = js.native
  var Title: ComponentClassP[AccordionTitleProps with js.Object] = js.native
}

