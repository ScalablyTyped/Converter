package typings.firebaseDashAdminLib.firebaseDashAdminMod

import typings.atGoogleDashCloudFirestoreLib.FirebaseFirestoreNs.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("firebase-admin", "firestore")
@js.native
object firestoreNs extends js.Object {
  @js.native
  /**
    * @param settings Configuration object. See [Firestore Documentation]
    * {@link https://firebase.google.com/docs/firestore/}
    */
  class Firestore ()
    extends typings.atGoogleDashCloudFirestoreLib.FirebaseFirestoreNs.Firestore {
    def this(settings: Settings) = this()
  }
  
}

