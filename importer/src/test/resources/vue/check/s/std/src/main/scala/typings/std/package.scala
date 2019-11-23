package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object std {
  import org.scalablytyped.runtime.StringDictionary

  type Element = Node
  type HTMLElement = Element
  type Readonly[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {readonly [ P in keyof T ]: T[P]}
    */ typings.std.stdStrings.Readonly with T
  type Record[K /* <: String */, T] = StringDictionary[K]
}
