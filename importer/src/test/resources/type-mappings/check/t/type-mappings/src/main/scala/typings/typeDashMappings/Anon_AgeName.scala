package typings.typeDashMappings

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Anon_AgeName extends js.Object {
  var age: Double
  var name: String
}

object Anon_AgeName {
  @inline
  def apply(age: Double, name: String): Anon_AgeName = {
    val __obj = js.Dynamic.literal(age = age, name = name)
  
    __obj.asInstanceOf[Anon_AgeName]
  }
}

