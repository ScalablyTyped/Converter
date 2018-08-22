package ScalablyTyped
package ReactLib.ReactModule.ReactNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait ReactElement[P] extends js.Object {
  val key: Key | scala.Null
  val props: P
  val `type`: java.lang.String | ComponentClass[P] | StatelessComponent[P]
}

