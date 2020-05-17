package typingsSlinky.react.mod

import org.scalablytyped.runtime.Instantiable1
import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - js.Function1[/ * props * / P, typingsSlinky.react.mod.ReactElement | scala.Null]
  - org.scalablytyped.runtime.Instantiable1[/ * props * / P, typingsSlinky.react.mod.Component[P, js.Any, js.Any]]
*/
trait JSXElementConstructor[P] extends js.Object

object JSXElementConstructor {
  @scala.inline
  implicit def apply[P](value: js.Function1[/* props */ P, slinky.core.facade.ReactElement | Null]): JSXElementConstructor[P] = value.asInstanceOf[JSXElementConstructor[P]]
  @scala.inline
  implicit def apply[P](value: Instantiable1[/* props */ P, ReactComponentClass[P]]): JSXElementConstructor[P] = value.asInstanceOf[JSXElementConstructor[P]]
}

