package simple

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, ReactMouseEventFrom}
import org.scalajs.dom.raw.HTMLButtonElement
import org.scalajs.dom.{document, window}
import typings.semanticDashUiDashReact.ScalaJsReact.Container
import typings.semanticDashUiDashReact.ScalaJsReact.Button
import typings.semanticDashUiDashReact.distCommonjsElementsButtonButtonMod.ButtonProps

object Main {

  def buttonOnClick(event: ReactMouseEventFrom[HTMLButtonElement], data: ButtonProps) = Callback {
    window.alert("You clicked me!")
  }

  def main(argv: Array[String]): Unit = {
    <.div(Container()(Button(onClick = buttonOnClick _)("Click here"))).renderIntoDOM(document.body)
  }
}
