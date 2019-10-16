package typings.firebaseAdmin

import typings.atGoogleCloudFirestore.FirebaseFirestore.Settings
import typings.firebaseAdmin.firebaseAdminMod.firestore.Firestore
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("firebase-admin", JSImport.Namespace)
@js.native
object firebaseAdminMod extends js.Object {
  @js.native
  object firestore extends js.Object {
    @js.native
    /**
      * @param settings Configuration object. See [Firestore Documentation]
      * {@link https://firebase.google.com/docs/firestore/}
      */
    class Firestore ()
      extends typings.atGoogleCloudFirestore.FirebaseFirestore.Firestore {
      def this(settings: Settings) = this()
    }
    
    def apply(): Firestore = js.native
    def apply(str: String): Firestore = js.native
  }
  
}

