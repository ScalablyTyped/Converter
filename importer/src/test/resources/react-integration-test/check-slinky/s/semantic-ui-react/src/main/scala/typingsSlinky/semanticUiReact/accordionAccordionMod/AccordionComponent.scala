package typingsSlinky.semanticUiReact.accordionAccordionMod

import slinky.core.ReactComponentClass
import typingsSlinky.react.mod.ComponentClass
import typingsSlinky.react.mod.ComponentState
import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsSlinky.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AccordionComponent extends ComponentClass[AccordionProps, ComponentState] {
  var Accordion: ReactComponentClass[AccordionAccordionProps] = js.native
  var Content: ReactComponentClass[AccordionContentProps] = js.native
  var Title: ReactComponentClass[AccordionTitleProps] = js.native
}

