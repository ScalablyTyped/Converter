package typings.cldrjs

import typings.cldrjs.mod.CldrFactory
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object supplementalMod {
  
  @JSImport("cldr/supplemental", JSImport.Namespace)
  @js.native
  val ^ : CldrFactory = js.native
  
  /* Syntax to write `supplementalMod` instead of `supplementalMod.^` */
  @scala.inline
  implicit def __is(ignored: supplementalMod.type): CldrFactory = typings.cldrjs.supplementalMod.^
}
