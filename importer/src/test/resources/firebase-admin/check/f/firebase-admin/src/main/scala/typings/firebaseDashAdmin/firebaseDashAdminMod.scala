package typings.firebaseDashAdmin

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.atGoogleDashCloudFirestore.FirebaseFirestore.Settings
import typings.firebaseDashAdmin.firebaseDashAdminMod.firestore.Firestore
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("firebase-admin", Namespace)
@js.native
object firebaseDashAdminMod extends js.Object {
  @js.native
  object firestore extends js.Object {
    @js.native
    /**
      * @param settings Configuration object. See [Firestore Documentation]
      * {@link https://firebase.google.com/docs/firestore/}
      */
    class Firestore () extends typings.atGoogleDashCloudFirestore.FirebaseFirestore.Firestore {
      def this(settings: Settings) = this()
    }
    
    def apply(): Firestore = js.native
    def apply(str: String): Firestore = js.native
  }
  
}

