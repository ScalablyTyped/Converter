package typingsJapgolly.semanticUiReact.accordionAccordionMod

import japgolly.scalajs.react.raw.React.ComponentClassP
import typingsJapgolly.react.mod.ComponentClass
import typingsJapgolly.react.mod.ComponentState
import typingsJapgolly.react.mod.StatelessComponent
import typingsJapgolly.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AccordionComponent extends ComponentClass[AccordionProps, ComponentState] {
  var Accordion: ComponentClassP[AccordionAccordionProps with js.Object] = js.native
  var Content: StatelessComponent[AccordionContentProps] = js.native
  var Title: ComponentClassP[AccordionTitleProps with js.Object] = js.native
}

