package typings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object std {
  
  type Element = typings.std.Node
  
  type HTMLElement = typings.std.Element
  
  type Readonly[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {readonly [ P in keyof T ]: T[P]}
    */ typings.std.stdStrings.Readonly with org.scalablytyped.runtime.TopLevel[T]
  
  type Record[K /* <: java.lang.String */, T] = org.scalablytyped.runtime.StringDictionary[T]
}
