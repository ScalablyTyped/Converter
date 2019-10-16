package typings.atGoogleCloudFirestore

import typings.atGoogleCloudFirestore.FirebaseFirestore.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@google-cloud/firestore", JSImport.Namespace)
@js.native
object atGoogleCloudFirestoreMod extends js.Object {
  @js.native
  /**
    * @param settings Configuration object. See [Firestore Documentation]
    * {@link https://firebase.google.com/docs/firestore/}
    */
  class Firestore ()
    extends typings.atGoogleCloudFirestore.FirebaseFirestore.Firestore {
    def this(settings: Settings) = this()
  }
  
}

