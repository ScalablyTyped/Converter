package typings.firebaseAdmin

import typings.googleCloudFirestore.FirebaseFirestore.Settings
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  object firestore {
    
    inline def apply(): Firestore = ^.asInstanceOf[js.Dynamic].apply().asInstanceOf[Firestore]
    inline def apply(str: String): Firestore = ^.asInstanceOf[js.Dynamic].apply(str.asInstanceOf[js.Any]).asInstanceOf[Firestore]
    
    @JSImport("firebase-admin", "firestore")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("firebase-admin", "firestore.Firestore")
    @js.native
    /**
      * @param settings Configuration object. See [Firestore Documentation]
      * {@link https://firebase.google.com/docs/firestore/}
      */
    class Firestore ()
      extends StObject
         with typings.googleCloudFirestore.FirebaseFirestore.Firestore {
      def this(settings: Settings) = this()
      
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
      /* CompleteClass */
      override def settings(settings: Settings): Unit = js.native
    }
  }
}
