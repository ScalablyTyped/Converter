package typings.semanticUiReact.modulesAccordionAccordionMod

import slinky.core.ReactComponentClass
import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typings.semanticUiReact.modulesAccordionAccordionContentMod.AccordionContentProps
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AccordionComponent extends ComponentClass[AccordionProps, ComponentState] {
  var Accordion: ReactComponentClass[AccordionAccordionProps] = js.native
  var Content: ReactComponentClass[AccordionContentProps] = js.native
  var Title: ReactComponentClass[AccordionTitleProps] = js.native
}

