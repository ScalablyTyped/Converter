package typings.atGoogleDashCloudFirestore.FirebaseFirestore

import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSGlobal("FirebaseFirestore.Firestore")
@js.native
/**
  * @param settings Configuration object. See [Firestore Documentation]
  * {@link https://firebase.google.com/docs/firestore/}
  */
class Firestore () extends js.Object {
  def this(settings: Settings) = this()
  /**
    * Specifies custom settings to be used to configure the `Firestore`
    * instance. Can only be invoked once and before any other Firestore
    * method.
    *
    * If settings are provided via both `settings()` and the `Firestore`
    * constructor, both settings objects are merged and any settings provided
    * via `settings()` take precedence.
    *
    * @param {object} settings The settings to use for all Firestore
    * operations.
    */
  def settings(settings: Settings): Unit = js.native
}

