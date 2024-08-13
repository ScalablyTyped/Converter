package typings.zootoolsEmailSpellChecker

import typings.zootoolsEmailSpellChecker.distLibTypesMod.MailSuggestion
import typings.zootoolsEmailSpellChecker.distLibTypesMod.UserOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distMod {
  
  @JSImport("@zootools/email-spell-checker/dist", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  object default {
    
    @JSImport("@zootools/email-spell-checker/dist", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("@zootools/email-spell-checker/dist", "default.POPULAR_DOMAINS")
    @js.native
    def POPULAR_DOMAINS: js.Array[String] = js.native
    inline def POPULAR_DOMAINS_=(x: js.Array[String]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("POPULAR_DOMAINS")(x.asInstanceOf[js.Any])
    
    @JSImport("@zootools/email-spell-checker/dist", "default.POPULAR_TLDS")
    @js.native
    def POPULAR_TLDS: js.Array[String] = js.native
    inline def POPULAR_TLDS_=(x: js.Array[String]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("POPULAR_TLDS")(x.asInstanceOf[js.Any])
    
    @JSImport("@zootools/email-spell-checker/dist", "default.run")
    @js.native
    def run: js.Function1[/* userOptions */ UserOptions, js.UndefOr[MailSuggestion]] = js.native
    inline def run(userOptions: UserOptions): js.UndefOr[MailSuggestion] = ^.asInstanceOf[js.Dynamic].applyDynamic("run")(userOptions.asInstanceOf[js.Any]).asInstanceOf[js.UndefOr[MailSuggestion]]
    inline def run_=(x: js.Function1[/* userOptions */ UserOptions, js.UndefOr[MailSuggestion]]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("run")(x.asInstanceOf[js.Any])
  }
  
  inline def run(userOptions: UserOptions): js.UndefOr[MailSuggestion] = ^.asInstanceOf[js.Dynamic].applyDynamic("run")(userOptions.asInstanceOf[js.Any]).asInstanceOf[js.UndefOr[MailSuggestion]]
}
