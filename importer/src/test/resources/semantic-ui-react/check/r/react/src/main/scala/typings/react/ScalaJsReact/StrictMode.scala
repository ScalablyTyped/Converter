package typings.react.ScalaJsReact

import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import typings.react.Anon_Children
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object StrictMode {
  def apply(): UnmountedSimple[
    Anon_Children, 
    MountedWithRawType[Anon_Children, js.Object, RawMounted[Anon_Children, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
    
  
    val f = japgolly.scalajs.react.JsComponent[typings.react.Anon_Children, japgolly.scalajs.react.Children.None, js.Object](typings.react.reactMod.StrictMode)
    f(__obj.asInstanceOf[typings.react.Anon_Children])
  }
}

