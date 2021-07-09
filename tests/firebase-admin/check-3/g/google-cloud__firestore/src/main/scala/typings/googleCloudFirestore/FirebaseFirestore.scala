package typings.googleCloudFirestore

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object FirebaseFirestore {
  
  @js.native
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
    def settings(settings: Settings): Unit = js.native
  }
  object Firestore {
    
    @scala.inline
    def apply(settings: Settings => Unit): Firestore = {
      val __obj = js.Dynamic.literal(settings = js.Any.fromFunction1(settings))
      __obj.asInstanceOf[Firestore]
    }
    
    @scala.inline
    implicit class FirestoreMutableBuilder[Self <: Firestore] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setSettings(value: Settings => Unit): Self = StObject.set(x, "settings", js.Any.fromFunction1(value))
    }
  }
  
  @js.native
  trait Settings extends StObject {
    
    var projectId: js.UndefOr[String] = js.native
  }
  object Settings {
    
    @scala.inline
    def apply(): Settings = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Settings]
    }
    
    @scala.inline
    implicit class SettingsMutableBuilder[Self <: Settings] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setProjectId(value: String): Self = StObject.set(x, "projectId", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setProjectIdUndefined: Self = StObject.set(x, "projectId", js.undefined)
    }
  }
}
