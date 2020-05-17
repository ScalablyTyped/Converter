package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Element
import org.scalablytyped.runtime.Instantiable1
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - js.Function1[/ * props * / P, typingsJapgolly.react.mod.ReactElement | scala.Null]
  - org.scalablytyped.runtime.Instantiable1[/ * props * / P, typingsJapgolly.react.mod.Component[P, js.Any, js.Any]]
*/
trait JSXElementConstructor[P] extends js.Object

object JSXElementConstructor {
  @scala.inline
  implicit def apply[P](value: js.Function1[/* props */ P, Element | Null]): JSXElementConstructor[P] = value.asInstanceOf[JSXElementConstructor[P]]
  @scala.inline
  implicit def apply[P](
    value: Instantiable1[
      /* props */ P, 
      japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object]
    ]
  ): JSXElementConstructor[P] = value.asInstanceOf[JSXElementConstructor[P]]
}

