package typings
package unionDashToDashInheritanceLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Foo2[U, V]
  extends Legal2[V, U]
     with Legal3[U, js.Any, V] {
  var u: U
  var v: V
}

