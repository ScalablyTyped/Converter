package typings.googleCloudFirestore

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object FirebaseFirestore {
  
  trait Firestore extends StObject {
    
    /**
      * Specifies custom settings to be used to configure the `Firestore`
      * instance. Can only be invoked once and before any other Firestore
      * method.
      *
      * If settings are provided via both `settings()` and the `Firestore`
      * constructor, both settings objects are merged and any settings provided
      * via `settings()` take precedence.
      *
      * @param {object} settings The settings to use for all Firestore
      * operations.
      */
    def settings(settings: Settings): Unit
  }
  object Firestore {
    
    inline def apply(settings: Settings => Unit): Firestore = {
      val __obj = js.Dynamic.literal(settings = js.Any.fromFunction1(settings))
      __obj.asInstanceOf[Firestore]
    }
    
    extension [Self <: Firestore](x: Self) {
      
      inline def setSettings(value: Settings => Unit): Self = StObject.set(x, "settings", js.Any.fromFunction1(value))
    }
  }
  
  trait Settings extends StObject {
    
    var projectId: js.UndefOr[String] = js.undefined
  }
  object Settings {
    
    inline def apply(): Settings = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Settings]
    }
    
    extension [Self <: Settings](x: Self) {
      
      inline def setProjectId(value: String): Self = StObject.set(x, "projectId", value.asInstanceOf[js.Any])
      
      inline def setProjectIdUndefined: Self = StObject.set(x, "projectId", js.undefined)
    }
  }
}
