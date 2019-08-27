package typings.stylis

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object stylisStylisMod {
  import org.scalablytyped.runtime.NullOr

  type Plugin = js.ThisFunction9[
    /* this */ Stylis, 
    /* context */ Context, 
    /* content */ String, 
    /* selector */ Selectors, 
    /* parent */ Selectors, 
    /* line */ Double, 
    /* column */ Double, 
    /* length */ Double, 
    /* at */ Double, 
    /* depth */ Double, 
    NullOr[Unit | String]
  ]
  type Selectors = js.Array[String]
}
