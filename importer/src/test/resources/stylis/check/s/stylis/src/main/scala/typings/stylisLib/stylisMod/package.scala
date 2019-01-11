package typings
package stylisLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object stylisMod {
  type Plugin = js.ThisFunction9[
    /* this */ Stylis, 
    /* context */ Context, 
    /* content */ java.lang.String, 
    /* selector */ Selectors, 
    /* parent */ Selectors, 
    /* line */ scala.Double, 
    /* column */ scala.Double, 
    /* length */ scala.Double, 
    /* at */ scala.Double, 
    /* depth */ scala.Double, 
    scala.Null | scala.Unit | java.lang.String
  ]
  type Selectors = js.Array[java.lang.String]
}
