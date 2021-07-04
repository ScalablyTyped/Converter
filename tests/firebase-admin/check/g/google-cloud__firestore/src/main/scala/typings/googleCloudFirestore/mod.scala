package typings.googleCloudFirestore

import typings.googleCloudFirestore.FirebaseFirestore.Settings
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("@google-cloud/firestore", "Firestore")
  @js.native
  /**
    * @param settings Configuration object. See [Firestore Documentation]
    * {@link https://firebase.google.com/docs/firestore/}
    */
  class Firestore ()
    extends StObject
       with typings.googleCloudFirestore.FirebaseFirestore.Firestore {
    def this(settings: Settings) = this()
  }
}
