package typings

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object stdLib {
  type Element = Node
  type HTMLElement = Element
  type Readonly[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {readonly [ P in keyof T ]: T[P]}
    */ stdLib.stdLibStrings.Readonly with T
  type Record[K /* <: String */, T] = StringDictionary[K]
}
