package typings.firebaseDashAdmin.firebaseDashAdminMod.firestoreNs

import typings.atGoogleDashCloudFirestore.FirebaseFirestoreNs.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("firebase-admin", "firestore.Firestore")
@js.native
/**
  * @param settings Configuration object. See [Firestore Documentation]
  * {@link https://firebase.google.com/docs/firestore/}
  */
class Firestore ()
  extends typings.atGoogleDashCloudFirestore.FirebaseFirestoreNs.Firestore {
  def this(settings: Settings) = this()
}

