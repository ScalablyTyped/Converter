package typings.std

import scala.concurrent.Future
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Promise[T] extends StObject
object Promise {
  
  @scala.inline
  implicit open class PromiseOps[T] (val promise: Promise[T]) extends AnyVal {
    
    def toFuture: Future[T] = toPromise.toFuture
    
    def toPromise: js.Promise[T] = promise.asInstanceOf[js.Promise[T]]
  }
}
