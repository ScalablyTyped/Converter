package typings.cldrjs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("cldrjs", JSImport.Namespace)
  @js.native
  val ^ : CldrFactory = js.native
  
  /* Syntax to write `mod` instead of `mod.^` */
  @scala.inline
  implicit def __is(ignored: mod.type): CldrFactory = typings.cldrjs.mod.^
  
  @js.native
  trait Attributes extends js.Object {
    
    var language: js.Any = js.native
  }
  object Attributes {
    
    @scala.inline
    def apply(language: js.Any): Attributes = {
      val __obj = js.Dynamic.literal(language = language.asInstanceOf[js.Any])
      __obj.asInstanceOf[Attributes]
    }
    
    @scala.inline
    implicit class AttributesOps[Self <: Attributes] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setLanguage(value: js.Any): Self = this.set("language", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait CldrFactory extends js.Object {
    
    def load(json: js.Any, otherJson: js.Any*): Unit = js.native
    
    def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
    
    def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
    
    def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  }
  object CldrFactory {
    
    @scala.inline
    def apply(
      load: (js.Any, /* repeated */ js.Any) => Unit,
      off: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
      on: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
      once: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit
    ): CldrFactory = {
      val __obj = js.Dynamic.literal(load = js.Any.fromFunction2(load), off = js.Any.fromFunction2(off), on = js.Any.fromFunction2(on), once = js.Any.fromFunction2(once))
      __obj.asInstanceOf[CldrFactory]
    }
    
    @scala.inline
    implicit class CldrFactoryOps[Self <: CldrFactory] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setLoad(value: (js.Any, /* repeated */ js.Any) => Unit): Self = this.set("load", js.Any.fromFunction2(value))
      
      @scala.inline
      def setOff(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = this.set("off", js.Any.fromFunction2(value))
      
      @scala.inline
      def setOn(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = this.set("on", js.Any.fromFunction2(value))
      
      @scala.inline
      def setOnce(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = this.set("once", js.Any.fromFunction2(value))
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
  @js.native
  trait CldrStatic extends js.Object {
    
    def get(path: String): js.Any = js.native
    
    def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
    
    def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
    
    def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
    
    def supplemental(path: String): js.Any = js.native
    def supplemental(paths: js.Array[String]): js.Any = js.native
    @JSName("supplemental")
    var supplemental_Original: SupplementalStatic = js.native
  }
  
  @js.native
  trait SupplementalStatic extends js.Object {
    
    def apply(path: String): js.Any = js.native
    def apply(paths: js.Array[String]): js.Any = js.native
    
    var timeData: TimeDataStatic = js.native
    
    var weekData: WeekDataStatic = js.native
  }
  
  @js.native
  trait TimeDataStatic extends js.Object {
    
    def allowed(): String = js.native
    
    def preferred(): String = js.native
  }
  object TimeDataStatic {
    
    @scala.inline
    def apply(allowed: () => String, preferred: () => String): TimeDataStatic = {
      val __obj = js.Dynamic.literal(allowed = js.Any.fromFunction0(allowed), preferred = js.Any.fromFunction0(preferred))
      __obj.asInstanceOf[TimeDataStatic]
    }
    
    @scala.inline
    implicit class TimeDataStaticOps[Self <: TimeDataStatic] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setAllowed(value: () => String): Self = this.set("allowed", js.Any.fromFunction0(value))
      
      @scala.inline
      def setPreferred(value: () => String): Self = this.set("preferred", js.Any.fromFunction0(value))
    }
  }
  
  @js.native
  trait WeekDataStatic extends js.Object {
    
    def firstDay(): String = js.native
    
    def minDays(): Double = js.native
  }
  object WeekDataStatic {
    
    @scala.inline
    def apply(firstDay: () => String, minDays: () => Double): WeekDataStatic = {
      val __obj = js.Dynamic.literal(firstDay = js.Any.fromFunction0(firstDay), minDays = js.Any.fromFunction0(minDays))
      __obj.asInstanceOf[WeekDataStatic]
    }
    
    @scala.inline
    implicit class WeekDataStaticOps[Self <: WeekDataStatic] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setFirstDay(value: () => String): Self = this.set("firstDay", js.Any.fromFunction0(value))
      
      @scala.inline
      def setMinDays(value: () => Double): Self = this.set("minDays", js.Any.fromFunction0(value))
    }
  }
}
