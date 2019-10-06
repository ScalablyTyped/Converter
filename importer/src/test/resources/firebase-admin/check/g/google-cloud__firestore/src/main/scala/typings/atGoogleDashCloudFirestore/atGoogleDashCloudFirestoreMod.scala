package typings.atGoogleDashCloudFirestore

import typings.atGoogleDashCloudFirestore.FirebaseFirestore.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@google-cloud/firestore", JSImport.Namespace)
@js.native
object atGoogleDashCloudFirestoreMod extends js.Object {
  @js.native
  /**
    * @param settings Configuration object. See [Firestore Documentation]
    * {@link https://firebase.google.com/docs/firestore/}
    */
  class Firestore ()
    extends typings.atGoogleDashCloudFirestore.FirebaseFirestore.Firestore {
    def this(settings: Settings) = this()
  }
  
}

