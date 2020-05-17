package typings.react.mod

import org.scalablytyped.runtime.Instantiable1
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - js.Function1[/ * props * / P, typings.react.mod.ReactElement | scala.Null]
  - org.scalablytyped.runtime.Instantiable1[/ * props * / P, typings.react.mod.Component[P, js.Any, js.Any]]
*/
trait JSXElementConstructor[P] extends js.Object

object JSXElementConstructor {
  @scala.inline
  implicit def apply[P](value: js.Function1[/* props */ P, ReactElement | Null]): JSXElementConstructor[P] = value.asInstanceOf[JSXElementConstructor[P]]
  @scala.inline
  implicit def apply[P](value: Instantiable1[/* props */ P, Component[P, js.Any, js.Any]]): JSXElementConstructor[P] = value.asInstanceOf[JSXElementConstructor[P]]
}

