package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object std {
  type Partial[T] = /* import warning: ImportType.apply Unsupported type mapping: 
  {[ P in keyof T ]:? T[P]}
    */ typings.std.stdStrings.Partial with T
  type Pick[T, K /* <: String */] = /* import warning: ImportType.apply Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ typings.std.stdStrings.Pick with T
}
