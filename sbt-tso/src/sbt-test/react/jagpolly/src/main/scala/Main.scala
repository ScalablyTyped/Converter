package simple

import japgolly.scalajs.react.{Callback, ReactMouseEventFrom}
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.document
import org.scalajs.dom.window
import org.scalajs.dom.raw.HTMLButtonElement
import typings.semanticDashUiDashReact.ScalaJsReact.{Button, Container}
import typings.semanticDashUiDashReact.distCommonjsElementsButtonButtonMod.ButtonProps

object Main {

  def buttonOnClick(event: ReactMouseEventFrom[HTMLButtonElement], data: ButtonProps) = Callback {
    window.alert("You clicked me!")
  }

  def main(argv: Array[String]): Unit = {
    <.div(Container()(Button(onClick = buttonOnClick _)("Click here"))).renderIntoDOM(document.body)
  }
}
