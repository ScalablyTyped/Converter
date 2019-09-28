package typings

import scala.scalajs.js
import scala.scalajs.js.`|`

package object std {
  import org.scalablytyped.runtime.StringDictionary

  type Partial[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ P in keyof T ]:? T[P]}
    */ typings.std.stdStrings.Partial with T
  type Record[K /* <: String */, T] = StringDictionary[K]
}
