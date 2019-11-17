package typings.semanticUiReact.modulesAccordionAccordionMod

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
  var Accordion: ComponentClass[AccordionAccordionProps, ComponentState] = js.native
  var Content: StatelessComponent[AccordionContentProps] = js.native
  var Title: ComponentClass[AccordionTitleProps, ComponentState] = js.native
}

