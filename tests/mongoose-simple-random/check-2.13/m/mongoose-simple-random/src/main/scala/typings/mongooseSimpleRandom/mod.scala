package typings.mongooseSimpleRandom

import typings.mongoose.mod.Document
import typings.mongoose.mod.ModelProperties
import typings.mongoose.mod.Schema
import typings.node.NodeJS.EventEmitter
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @scala.inline
  def apply(schema: Schema): Unit = ^.asInstanceOf[js.Dynamic].apply(schema.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  @JSImport("mongoose-simple-random", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  /* augmented module */
  object mongooseAugmentingMod {
    
    @js.native
    trait Model[T /* <: Document */]
      extends StObject
         with EventEmitter
         with ModelProperties {
      
      def findRandom(conditions: js.Object): Unit = js.native
      def findRandom(conditions: js.Object, projection: js.Object): Unit = js.native
      def findRandom(conditions: js.Object, projection: js.Object, options: js.Object): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: js.Object,
        options: js.Object,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: js.Object,
        options: Null,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: js.Object,
        options: Unit,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(conditions: js.Object, projection: Null, options: js.Object): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: Null,
        options: js.Object,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: Null,
        options: Null,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: Null,
        options: Unit,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(conditions: js.Object, projection: Unit, options: js.Object): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: Unit,
        options: js.Object,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: Unit,
        options: Null,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
      def findRandom(
        conditions: js.Object,
        projection: Unit,
        options: Unit,
        callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
      ): Unit = js.native
    }
  }
}
