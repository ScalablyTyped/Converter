package typings.googleCloudFirestore

import typings.googleCloudFirestore.FirebaseFirestore.Settings
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("@google-cloud/firestore", JSImport.Namespace)
@js.native
object mod extends js.Object {
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

