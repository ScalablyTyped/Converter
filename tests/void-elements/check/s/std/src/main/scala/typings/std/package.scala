package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object std {
  
  type Partial[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in keyof T ]:? T[P]}
    */ typings.std.stdStrings.Partial with org.scalablytyped.runtime.TopLevel[T]
  
  type Record[K /* <: /* keyof any */ java.lang.String */, T] = org.scalablytyped.runtime.StringDictionary[T]
}
