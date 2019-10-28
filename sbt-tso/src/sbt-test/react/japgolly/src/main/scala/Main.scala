package simple

import japgolly.scalajs.react.{Callback, CallbackTo, ReactMouseEventFrom}
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.document
import org.scalajs.dom.window
import org.scalajs.dom.raw.HTMLButtonElement
import typings.semanticUiReact.commonjsElementsButtonButtonMod.ButtonProps
import typings.semanticUiReact.commonjsGenericMod.SemanticCOLORS
import typings.semanticUiReact.semanticUiReactStrings.money
import typings.semanticUiReact.japgolly.{Button, Container, Icon}

import scala.scalajs.js

object Main {
  def buttonOnClick(event: ReactMouseEventFrom[HTMLButtonElement], data: ButtonProps) = Callback {
    val me = js.undefined
    window.alert("You clicked me!")
  }

  def main(argv: Array[String]): Unit = {
    <.div(Container()(Button(color = SemanticCOLORS.red, onClick = buttonOnClick _)(Icon(name = money)()))).renderIntoDOM(document.body)
  }
}
