package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object stdLib {
  type Partial[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ P in keyof T ]:? T[P]}
    */ typings.stdLib.stdLibStrings.Partial with T
  type Pick[T, K /* <: String */] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ typings.stdLib.stdLibStrings.Pick with T
}
