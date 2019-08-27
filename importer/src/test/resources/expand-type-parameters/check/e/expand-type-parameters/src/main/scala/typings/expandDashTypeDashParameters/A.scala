package typings.expandDashTypeDashParameters

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveMultipleInheritance.findNewParents Dropped parents 
- typings.expandDashTypeDashParameters.TA because Already inherited */ trait A extends B {
  var a: Double
}

object A {
  @scala.inline
  def apply(a: Double, b: String): A = {
    val __obj = js.Dynamic.literal(a = a, b = b)
  
    __obj.asInstanceOf[A]
  }
}

