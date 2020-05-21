package typings.googleCloudFirestore.global

import typings.googleCloudFirestore.FirebaseFirestore.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("FirebaseFirestore")
@js.native
object FirebaseFirestore extends js.Object {
  @js.native
  /**
    * @param settings Configuration object. See [Firestore Documentation]
    * {@link https://firebase.google.com/docs/firestore/}
    */
  class Firestore ()
    extends typings.googleCloudFirestore.FirebaseFirestore.Firestore {
    def this(settings: Settings) = this()
  }
  
}

