package ScalablyTyped
package ReactLib
package ReactModule
package ReactNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait ReactElement[P] extends js.Object {
  val key: ReactLib.ReactModule.ReactNamespace.Key | scala.Null
  val props: P
  val `type`: java.lang.String | ReactLib.ReactModule.ReactNamespace.ComponentClass[P] | ReactLib.ReactModule.ReactNamespace.SFC[P]
}

