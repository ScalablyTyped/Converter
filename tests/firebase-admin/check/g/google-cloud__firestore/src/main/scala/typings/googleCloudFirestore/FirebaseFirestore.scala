package typings.googleCloudFirestore

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object FirebaseFirestore {
  
  @js.native
  trait Firestore extends js.Object {
    
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
  object Firestore {
    
    @scala.inline
    def apply(settings: Settings => Unit): Firestore = {
      val __obj = js.Dynamic.literal(settings = js.Any.fromFunction1(settings))
      __obj.asInstanceOf[Firestore]
    }
    
    @scala.inline
    implicit class FirestoreOps[Self <: Firestore] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setSettings(value: Settings => Unit): Self = this.set("settings", js.Any.fromFunction1(value))
    }
  }
  
  @js.native
  trait Settings extends js.Object {
    
    var projectId: js.UndefOr[String] = js.native
  }
  object Settings {
    
    @scala.inline
    def apply(): Settings = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Settings]
    }
    
    @scala.inline
    implicit class SettingsOps[Self <: Settings] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setProjectId(value: String): Self = this.set("projectId", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteProjectId: Self = this.set("projectId", js.undefined)
    }
  }
}
