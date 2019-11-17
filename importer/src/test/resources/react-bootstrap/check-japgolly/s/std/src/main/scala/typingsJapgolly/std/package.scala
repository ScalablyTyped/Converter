package typingsJapgolly

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object std {
  type Partial[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in keyof T ]:? T[P]}
    */ typingsJapgolly.std.stdStrings.Partial with T
  type Pick[T, K /* <: String */] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ typingsJapgolly.std.stdStrings.Pick with T
}
