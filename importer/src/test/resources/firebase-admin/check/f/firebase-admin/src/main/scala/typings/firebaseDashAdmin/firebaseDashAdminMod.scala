package typings.firebaseDashAdmin

import typings.atGoogleDashCloudFirestore.FirebaseFirestore.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("firebase-admin", JSImport.Namespace)
@js.native
object firebaseDashAdminMod extends js.Object {
  @js.native
  object firestore extends js.Object {
    @js.native
    /**
      * @param settings Configuration object. See [Firestore Documentation]
      * {@link https://firebase.google.com/docs/firestore/}
      */
    class Firestore ()
      extends typings.atGoogleDashCloudFirestore.FirebaseFirestore.Firestore {
      def this(settings: Settings) = this()
    }
    
    def apply(): Firestore = js.native
    def apply(str: String): Firestore = js.native
  }
  
}

