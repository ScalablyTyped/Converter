package typings.fullcalendar

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mixinMod {
  
  @JSImport("fullcalendar/Mixin", JSImport.Default)
  @js.native
  open class default () extends Default_
  /* static members */
  object default {
    
    @JSImport("fullcalendar/Mixin", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    inline def mixInto(destClass: Any): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("mixInto")(destClass.asInstanceOf[js.Any]).asInstanceOf[Unit]
    
    inline def mixOver(destClass: Any): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("mixOver")(destClass.asInstanceOf[js.Any]).asInstanceOf[Unit]
  }
  
  @JSImport("fullcalendar/Mixin", "Default")
  @js.native
  open class Default_ () extends StObject
  /* static members */
  object Default_ {
    
    @JSImport("fullcalendar/Mixin", "Default")
    @js.native
    val ^ : js.Any = js.native
    
    inline def mixInto(destClass: Any): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("mixInto")(destClass.asInstanceOf[js.Any]).asInstanceOf[Unit]
    
    inline def mixOver(destClass: Any): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("mixOver")(destClass.asInstanceOf[js.Any]).asInstanceOf[Unit]
  }
}
