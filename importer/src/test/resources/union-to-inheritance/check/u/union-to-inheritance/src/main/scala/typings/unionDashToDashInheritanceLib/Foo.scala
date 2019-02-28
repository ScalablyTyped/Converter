package typings
package unionDashToDashInheritanceLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Foo[U]
  extends Legal1[U]
     with Legal2[U, js.Any]
     with Legal3[js.Any, js.Any, U] {
  var value: U
}

