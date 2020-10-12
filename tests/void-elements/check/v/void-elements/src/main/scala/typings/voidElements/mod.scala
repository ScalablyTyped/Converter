package typings.voidElements

import typings.std.Partial
import typings.std.Record
import typings.voidElements.voidElementsBooleans.`true`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("void-elements", JSImport.Namespace)
  @js.native
  val ^ : Partial[Record[String, `true`]] = js.native
  
  /* Syntax to write `mod` instead of `mod.^` */
  @scala.inline
  implicit def __is(ignored: mod.type): Partial[Record[String, `true`]] = typings.voidElements.mod.^
}
