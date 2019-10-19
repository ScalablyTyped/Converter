package typings.firebaseAdmin

import typings.googleCloudFirestore.FirebaseFirestore.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("firebase-admin", JSImport.Namespace)
@js.native
object mod extends js.Object {
  @js.native
  object firestore extends js.Object {
    @js.native
    /**
      * @param settings Configuration object. See [Firestore Documentation]
      * {@link https://firebase.google.com/docs/firestore/}
      */
    class Firestore ()
      extends typings.googleCloudFirestore.FirebaseFirestore.Firestore {
      def this(settings: Settings) = this()
    }
    
    def apply(): Firestore = js.native
    def apply(str: String): Firestore = js.native
  }
  
}

