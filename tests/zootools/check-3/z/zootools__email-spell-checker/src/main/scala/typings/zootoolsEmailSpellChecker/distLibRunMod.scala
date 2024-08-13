package typings.zootoolsEmailSpellChecker

import typings.zootoolsEmailSpellChecker.distLibTypesMod.MailSuggestion
import typings.zootoolsEmailSpellChecker.distLibTypesMod.UserOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distLibRunMod {
  
  @JSImport("@zootools/email-spell-checker/dist/lib/run", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def default(userOptions: UserOptions): js.UndefOr[MailSuggestion] = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(userOptions.asInstanceOf[js.Any]).asInstanceOf[js.UndefOr[MailSuggestion]]
}
