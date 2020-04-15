package typings.semanticUiReact

import typings.react.mod.ComponentType
import typings.semanticUiReact.accordionMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object semanticUiReactComponents extends semanticUiReactProps {
  @scala.inline
  def Accordion: ComponentType[AccordionProps] = js.constructorOf[default].asInstanceOf[ComponentType[AccordionProps]]
  @scala.inline
  def AccordionAccordion: ComponentType[AccordionAccordionProps] = js.constructorOf[typings.semanticUiReact.accordionAccordionAccordionMod.default].asInstanceOf[ComponentType[AccordionAccordionProps]]
  @scala.inline
  def AccordionContent: ComponentType[AccordionContentProps] = typings.semanticUiReact.accordionContentMod.default.asInstanceOf[ComponentType[AccordionContentProps]]
  @scala.inline
  def AccordionPanel: ComponentType[AccordionPanelProps] = js.constructorOf[typings.semanticUiReact.accordionPanelMod.default].asInstanceOf[ComponentType[AccordionPanelProps]]
  @scala.inline
  def AccordionTitle: ComponentType[AccordionTitleProps] = js.constructorOf[typings.semanticUiReact.accordionTitleMod.default].asInstanceOf[ComponentType[AccordionTitleProps]]
  @scala.inline
  def Button: ComponentType[ButtonProps] = js.constructorOf[typings.semanticUiReact.mod.default].asInstanceOf[ComponentType[ButtonProps]]
  @scala.inline
  def ButtonContent: ComponentType[ButtonContentProps] = typings.semanticUiReact.buttonContentMod.default.asInstanceOf[ComponentType[ButtonContentProps]]
  @scala.inline
  def ButtonGroup: ComponentType[ButtonGroupProps] = typings.semanticUiReact.buttonGroupMod.default.asInstanceOf[ComponentType[ButtonGroupProps]]
  @scala.inline
  def ButtonOr: ComponentType[ButtonOrProps] = typings.semanticUiReact.buttonOrMod.default.asInstanceOf[ComponentType[ButtonOrProps]]
  @scala.inline
  def Container: ComponentType[ContainerProps] = typings.semanticUiReact.containerMod.default.asInstanceOf[ComponentType[ContainerProps]]
  @scala.inline
  def Input: ComponentType[InputProps] = js.constructorOf[typings.semanticUiReact.inputMod.default].asInstanceOf[ComponentType[InputProps]]
  @scala.inline
  def TestContainer: ComponentType[TestContainerProps] = typings.semanticUiReact.testContainerMod.default.asInstanceOf[ComponentType[TestContainerProps]]
}

