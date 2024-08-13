package typings.zootoolsEmailSpellChecker

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distLibTypesMod {
  
  type DistanceFunction = js.Function3[/* a */ String, /* b */ String, /* threshold */ js.UndefOr[Double], Double]
  
  trait EmailsPart extends StObject {
    
    var address: String
    
    var domain: String
    
    var secondLevelDomain: String
    
    var topLevelDomain: String
  }
  object EmailsPart {
    
    inline def apply(address: String, domain: String, secondLevelDomain: String, topLevelDomain: String): EmailsPart = {
      val __obj = js.Dynamic.literal(address = address.asInstanceOf[js.Any], domain = domain.asInstanceOf[js.Any], secondLevelDomain = secondLevelDomain.asInstanceOf[js.Any], topLevelDomain = topLevelDomain.asInstanceOf[js.Any])
      __obj.asInstanceOf[EmailsPart]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: EmailsPart] (val x: Self) extends AnyVal {
      
      inline def setAddress(value: String): Self = StObject.set(x, "address", value.asInstanceOf[js.Any])
      
      inline def setDomain(value: String): Self = StObject.set(x, "domain", value.asInstanceOf[js.Any])
      
      inline def setSecondLevelDomain(value: String): Self = StObject.set(x, "secondLevelDomain", value.asInstanceOf[js.Any])
      
      inline def setTopLevelDomain(value: String): Self = StObject.set(x, "topLevelDomain", value.asInstanceOf[js.Any])
    }
  }
  
  trait MailSuggestion extends StObject {
    
    var address: String
    
    var domain: String
    
    var full: String
  }
  object MailSuggestion {
    
    inline def apply(address: String, domain: String, full: String): MailSuggestion = {
      val __obj = js.Dynamic.literal(address = address.asInstanceOf[js.Any], domain = domain.asInstanceOf[js.Any], full = full.asInstanceOf[js.Any])
      __obj.asInstanceOf[MailSuggestion]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: MailSuggestion] (val x: Self) extends AnyVal {
      
      inline def setAddress(value: String): Self = StObject.set(x, "address", value.asInstanceOf[js.Any])
      
      inline def setDomain(value: String): Self = StObject.set(x, "domain", value.asInstanceOf[js.Any])
      
      inline def setFull(value: String): Self = StObject.set(x, "full", value.asInstanceOf[js.Any])
    }
  }
  
  trait Options extends StObject {
    
    def distanceFunction(a: String, b: String): Double
    def distanceFunction(a: String, b: String, threshold: Double): Double
    @JSName("distanceFunction")
    var distanceFunction_Original: DistanceFunction
    
    var domainThreshold: Double
    
    var domains: js.Array[String]
    
    var email: String
    
    var empty: js.UndefOr[js.Function0[Unit]] = js.undefined
    
    var secondLevelDomains: js.Array[String]
    
    var secondLevelThreshold: Double
    
    var suggested: js.UndefOr[js.Function1[/* suggestion */ js.UndefOr[MailSuggestion], Unit]] = js.undefined
    
    var topLevelDomains: js.Array[String]
    
    var topLevelThreshold: Double
  }
  object Options {
    
    inline def apply(
      distanceFunction: (/* a */ String, /* b */ String, /* threshold */ js.UndefOr[Double]) => Double,
      domainThreshold: Double,
      domains: js.Array[String],
      email: String,
      secondLevelDomains: js.Array[String],
      secondLevelThreshold: Double,
      topLevelDomains: js.Array[String],
      topLevelThreshold: Double
    ): Options = {
      val __obj = js.Dynamic.literal(distanceFunction = js.Any.fromFunction3(distanceFunction), domainThreshold = domainThreshold.asInstanceOf[js.Any], domains = domains.asInstanceOf[js.Any], email = email.asInstanceOf[js.Any], secondLevelDomains = secondLevelDomains.asInstanceOf[js.Any], secondLevelThreshold = secondLevelThreshold.asInstanceOf[js.Any], topLevelDomains = topLevelDomains.asInstanceOf[js.Any], topLevelThreshold = topLevelThreshold.asInstanceOf[js.Any])
      __obj.asInstanceOf[Options]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Options] (val x: Self) extends AnyVal {
      
      inline def setDistanceFunction(value: (/* a */ String, /* b */ String, /* threshold */ js.UndefOr[Double]) => Double): Self = StObject.set(x, "distanceFunction", js.Any.fromFunction3(value))
      
      inline def setDomainThreshold(value: Double): Self = StObject.set(x, "domainThreshold", value.asInstanceOf[js.Any])
      
      inline def setDomains(value: js.Array[String]): Self = StObject.set(x, "domains", value.asInstanceOf[js.Any])
      
      inline def setDomainsVarargs(value: String*): Self = StObject.set(x, "domains", js.Array(value*))
      
      inline def setEmail(value: String): Self = StObject.set(x, "email", value.asInstanceOf[js.Any])
      
      inline def setEmpty(value: () => Unit): Self = StObject.set(x, "empty", js.Any.fromFunction0(value))
      
      inline def setEmptyUndefined: Self = StObject.set(x, "empty", js.undefined)
      
      inline def setSecondLevelDomains(value: js.Array[String]): Self = StObject.set(x, "secondLevelDomains", value.asInstanceOf[js.Any])
      
      inline def setSecondLevelDomainsVarargs(value: String*): Self = StObject.set(x, "secondLevelDomains", js.Array(value*))
      
      inline def setSecondLevelThreshold(value: Double): Self = StObject.set(x, "secondLevelThreshold", value.asInstanceOf[js.Any])
      
      inline def setSuggested(value: /* suggestion */ js.UndefOr[MailSuggestion] => Unit): Self = StObject.set(x, "suggested", js.Any.fromFunction1(value))
      
      inline def setSuggestedUndefined: Self = StObject.set(x, "suggested", js.undefined)
      
      inline def setTopLevelDomains(value: js.Array[String]): Self = StObject.set(x, "topLevelDomains", value.asInstanceOf[js.Any])
      
      inline def setTopLevelDomainsVarargs(value: String*): Self = StObject.set(x, "topLevelDomains", js.Array(value*))
      
      inline def setTopLevelThreshold(value: Double): Self = StObject.set(x, "topLevelThreshold", value.asInstanceOf[js.Any])
    }
  }
  
  trait UserOptions extends StObject {
    
    var distanceFunction: js.UndefOr[DistanceFunction] = js.undefined
    
    var domainThreshold: js.UndefOr[Double] = js.undefined
    
    var domains: js.UndefOr[js.Array[String]] = js.undefined
    
    var email: String
    
    var empty: js.UndefOr[js.Function0[Unit]] = js.undefined
    
    var secondLevelDomains: js.UndefOr[js.Array[String]] = js.undefined
    
    var secondLevelThreshold: js.UndefOr[Double] = js.undefined
    
    var suggested: js.UndefOr[js.Function1[/* suggestion */ js.UndefOr[MailSuggestion], Unit]] = js.undefined
    
    var topLevelDomains: js.UndefOr[js.Array[String]] = js.undefined
    
    var topLevelThreshold: js.UndefOr[Double] = js.undefined
  }
  object UserOptions {
    
    inline def apply(email: String): UserOptions = {
      val __obj = js.Dynamic.literal(email = email.asInstanceOf[js.Any])
      __obj.asInstanceOf[UserOptions]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: UserOptions] (val x: Self) extends AnyVal {
      
      inline def setDistanceFunction(value: (/* a */ String, /* b */ String, /* threshold */ js.UndefOr[Double]) => Double): Self = StObject.set(x, "distanceFunction", js.Any.fromFunction3(value))
      
      inline def setDistanceFunctionUndefined: Self = StObject.set(x, "distanceFunction", js.undefined)
      
      inline def setDomainThreshold(value: Double): Self = StObject.set(x, "domainThreshold", value.asInstanceOf[js.Any])
      
      inline def setDomainThresholdUndefined: Self = StObject.set(x, "domainThreshold", js.undefined)
      
      inline def setDomains(value: js.Array[String]): Self = StObject.set(x, "domains", value.asInstanceOf[js.Any])
      
      inline def setDomainsUndefined: Self = StObject.set(x, "domains", js.undefined)
      
      inline def setDomainsVarargs(value: String*): Self = StObject.set(x, "domains", js.Array(value*))
      
      inline def setEmail(value: String): Self = StObject.set(x, "email", value.asInstanceOf[js.Any])
      
      inline def setEmpty(value: () => Unit): Self = StObject.set(x, "empty", js.Any.fromFunction0(value))
      
      inline def setEmptyUndefined: Self = StObject.set(x, "empty", js.undefined)
      
      inline def setSecondLevelDomains(value: js.Array[String]): Self = StObject.set(x, "secondLevelDomains", value.asInstanceOf[js.Any])
      
      inline def setSecondLevelDomainsUndefined: Self = StObject.set(x, "secondLevelDomains", js.undefined)
      
      inline def setSecondLevelDomainsVarargs(value: String*): Self = StObject.set(x, "secondLevelDomains", js.Array(value*))
      
      inline def setSecondLevelThreshold(value: Double): Self = StObject.set(x, "secondLevelThreshold", value.asInstanceOf[js.Any])
      
      inline def setSecondLevelThresholdUndefined: Self = StObject.set(x, "secondLevelThreshold", js.undefined)
      
      inline def setSuggested(value: /* suggestion */ js.UndefOr[MailSuggestion] => Unit): Self = StObject.set(x, "suggested", js.Any.fromFunction1(value))
      
      inline def setSuggestedUndefined: Self = StObject.set(x, "suggested", js.undefined)
      
      inline def setTopLevelDomains(value: js.Array[String]): Self = StObject.set(x, "topLevelDomains", value.asInstanceOf[js.Any])
      
      inline def setTopLevelDomainsUndefined: Self = StObject.set(x, "topLevelDomains", js.undefined)
      
      inline def setTopLevelDomainsVarargs(value: String*): Self = StObject.set(x, "topLevelDomains", js.Array(value*))
      
      inline def setTopLevelThreshold(value: Double): Self = StObject.set(x, "topLevelThreshold", value.asInstanceOf[js.Any])
      
      inline def setTopLevelThresholdUndefined: Self = StObject.set(x, "topLevelThreshold", js.undefined)
    }
  }
}
