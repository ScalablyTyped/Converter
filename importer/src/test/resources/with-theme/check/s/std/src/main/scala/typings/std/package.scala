package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object std {
  type Pick[T, K /* <: String */] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ typings.std.stdStrings.Pick with T
}
