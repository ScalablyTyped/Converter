package typings.cldrjs

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod extends Shortcut {
  
  @JSImport("cldrjs", JSImport.Namespace)
  @js.native
  val ^ : CldrFactory = js.native
  
  trait Attributes extends StObject {
    
    var language: js.Any
  }
  object Attributes {
    
    inline def apply(language: js.Any): Attributes = {
      val __obj = js.Dynamic.literal(language = language.asInstanceOf[js.Any])
      __obj.asInstanceOf[Attributes]
    }
    
    extension [Self <: Attributes](x: Self) {
      
      inline def setLanguage(value: js.Any): Self = StObject.set(x, "language", value.asInstanceOf[js.Any])
    }
  }
  
  trait CldrFactory extends StObject {
    
    def load(json: js.Any, otherJson: js.Any*): Unit
    
    def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
    
    def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
    
    def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
  }
  object CldrFactory {
    
    inline def apply(
      load: (js.Any, /* repeated */ js.Any) => Unit,
      off: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
      on: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
      once: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit
    ): CldrFactory = {
      val __obj = js.Dynamic.literal(load = js.Any.fromFunction2(load), off = js.Any.fromFunction2(off), on = js.Any.fromFunction2(on), once = js.Any.fromFunction2(once))
      __obj.asInstanceOf[CldrFactory]
    }
    
    extension [Self <: CldrFactory](x: Self) {
      
      inline def setLoad(value: (js.Any, /* repeated */ js.Any) => Unit): Self = StObject.set(x, "load", js.Any.fromFunction2(value))
      
      inline def setOff(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = StObject.set(x, "off", js.Any.fromFunction2(value))
      
      inline def setOn(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = StObject.set(x, "on", js.Any.fromFunction2(value))
      
      inline def setOnce(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = StObject.set(x, "once", js.Any.fromFunction2(value))
    }
  }
  
  /**
    * @name CldrStatic
    * @memberof cldr
    * @kind interface
    *
    * @description
    * The cldr class definition.
    */
  trait CldrStatic extends StObject {
    
    def get(path: String): js.Any
    
    def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
    
    def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
    
    def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
    
    def supplemental(path: String): js.Any
    def supplemental(paths: js.Array[String]): js.Any
    @JSName("supplemental")
    var supplemental_Original: SupplementalStatic
  }
  object CldrStatic {
    
    inline def apply(
      get: String => js.Any,
      off: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
      on: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
      once: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
      supplemental: SupplementalStatic
    ): CldrStatic = {
      val __obj = js.Dynamic.literal(get = js.Any.fromFunction1(get), off = js.Any.fromFunction2(off), on = js.Any.fromFunction2(on), once = js.Any.fromFunction2(once), supplemental = supplemental.asInstanceOf[js.Any])
      __obj.asInstanceOf[CldrStatic]
    }
    
    extension [Self <: CldrStatic](x: Self) {
      
      inline def setGet(value: String => js.Any): Self = StObject.set(x, "get", js.Any.fromFunction1(value))
      
      inline def setOff(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = StObject.set(x, "off", js.Any.fromFunction2(value))
      
      inline def setOn(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = StObject.set(x, "on", js.Any.fromFunction2(value))
      
      inline def setOnce(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = StObject.set(x, "once", js.Any.fromFunction2(value))
      
      inline def setSupplemental(value: SupplementalStatic): Self = StObject.set(x, "supplemental", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait SupplementalStatic extends StObject {
    
    def apply(path: String): js.Any = js.native
    def apply(paths: js.Array[String]): js.Any = js.native
    
    var timeData: TimeDataStatic = js.native
    
    var weekData: WeekDataStatic = js.native
  }
  
  trait TimeDataStatic extends StObject {
    
    def allowed(): String
    
    def preferred(): String
  }
  object TimeDataStatic {
    
    inline def apply(allowed: () => String, preferred: () => String): TimeDataStatic = {
      val __obj = js.Dynamic.literal(allowed = js.Any.fromFunction0(allowed), preferred = js.Any.fromFunction0(preferred))
      __obj.asInstanceOf[TimeDataStatic]
    }
    
    extension [Self <: TimeDataStatic](x: Self) {
      
      inline def setAllowed(value: () => String): Self = StObject.set(x, "allowed", js.Any.fromFunction0(value))
      
      inline def setPreferred(value: () => String): Self = StObject.set(x, "preferred", js.Any.fromFunction0(value))
    }
  }
  
  trait WeekDataStatic extends StObject {
    
    def firstDay(): String
    
    def minDays(): Double
  }
  object WeekDataStatic {
    
    inline def apply(firstDay: () => String, minDays: () => Double): WeekDataStatic = {
      val __obj = js.Dynamic.literal(firstDay = js.Any.fromFunction0(firstDay), minDays = js.Any.fromFunction0(minDays))
      __obj.asInstanceOf[WeekDataStatic]
    }
    
    extension [Self <: WeekDataStatic](x: Self) {
      
      inline def setFirstDay(value: () => String): Self = StObject.set(x, "firstDay", js.Any.fromFunction0(value))
      
      inline def setMinDays(value: () => Double): Self = StObject.set(x, "minDays", js.Any.fromFunction0(value))
    }
  }
  
  type _To = CldrFactory
  
  /* This means you don't have to write `^`, but can instead just say `mod.foo` */
  override def _to: CldrFactory = ^
}
