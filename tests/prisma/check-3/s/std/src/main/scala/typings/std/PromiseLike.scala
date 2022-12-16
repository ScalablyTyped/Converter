package typings.std

import scala.concurrent.Future
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait PromiseLike[T] extends StObject
object PromiseLike {
  
  @scala.inline
  implicit open class PromiseLikeOps[T] (val promise: PromiseLike[T]) extends AnyVal {
    
    def toFuture: Future[T] = toPromise.toFuture
    
    def toPromise: js.Promise[T] = promise.asInstanceOf[js.Promise[T]]
  }
}
