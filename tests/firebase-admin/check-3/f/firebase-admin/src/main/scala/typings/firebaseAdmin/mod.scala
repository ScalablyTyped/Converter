package typings.firebaseAdmin

import typings.googleCloudFirestore.FirebaseFirestore.Settings
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inferred short module name */
object mod {
  
  object firestore {
    
    inline def apply(): typings.firebaseAdmin.libMod.firestore.Firestore = ^.asInstanceOf[js.Dynamic].apply().asInstanceOf[typings.firebaseAdmin.libMod.firestore.Firestore]
    inline def apply(str: String): typings.firebaseAdmin.libMod.firestore.Firestore = ^.asInstanceOf[js.Dynamic].apply(str.asInstanceOf[js.Any]).asInstanceOf[typings.firebaseAdmin.libMod.firestore.Firestore]
    
    @JSImport("firebase-admin", "firestore")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("firebase-admin", "firestore.Firestore")
    @js.native
    /**
      * @param settings Configuration object. See [Firestore Documentation]
      * {@link https://firebase.google.com/docs/firestore/}
      */
    open class Firestore ()
      extends typings.firebaseAdmin.libMod.firestore.Firestore {
      def this(settings: Settings) = this()
    }
  }
}
