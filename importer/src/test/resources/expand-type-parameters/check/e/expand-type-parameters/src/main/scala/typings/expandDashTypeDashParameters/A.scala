package typings.expandDashTypeDashParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveMultipleInheritance.findNewParents newComments Dropped parents 
- typings.expandDashTypeDashParameters.TA because Already inherited */ trait A extends B {
  var a: Double
}

object A {
  @scala.inline
  def apply(a: Double, b: String): A = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[A]
  }
}

