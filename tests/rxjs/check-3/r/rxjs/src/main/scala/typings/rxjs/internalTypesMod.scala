package typings.rxjs

import _root_.typings.rxjs.internalObservableMod.Observable
import _root_.typings.rxjs.internalSubscriptionMod.Subscription
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object internalTypesMod {
  
  trait CompletionObserver[T] extends StObject {
    
    var closed: js.UndefOr[Boolean] = js.undefined
    
    def complete(): Unit
    
    var error: js.UndefOr[js.Function1[/* err */ Any, Unit]] = js.undefined
    
    var next: js.UndefOr[js.Function1[/* value */ T, Unit]] = js.undefined
  }
  object CompletionObserver {
    
    inline def apply[T](complete: () => Unit): CompletionObserver[T] = {
      val __obj = js.Dynamic.literal(complete = js.Any.fromFunction0(complete))
      __obj.asInstanceOf[CompletionObserver[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: CompletionObserver[?], T] (val x: Self & CompletionObserver[T]) extends AnyVal {
      
      inline def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      inline def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      inline def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      inline def setError(value: /* err */ Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      inline def setErrorUndefined: Self = StObject.set(x, "error", js.undefined)
      
      inline def setNext(value: /* value */ T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
      
      inline def setNextUndefined: Self = StObject.set(x, "next", js.undefined)
    }
  }
  
  trait ErrorObserver[T] extends StObject {
    
    var closed: js.UndefOr[Boolean] = js.undefined
    
    var complete: js.UndefOr[js.Function0[Unit]] = js.undefined
    
    def error(err: Any): Unit
    
    var next: js.UndefOr[js.Function1[/* value */ T, Unit]] = js.undefined
  }
  object ErrorObserver {
    
    inline def apply[T](error: Any => Unit): ErrorObserver[T] = {
      val __obj = js.Dynamic.literal(error = js.Any.fromFunction1(error))
      __obj.asInstanceOf[ErrorObserver[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ErrorObserver[?], T] (val x: Self & ErrorObserver[T]) extends AnyVal {
      
      inline def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      inline def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      inline def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      inline def setCompleteUndefined: Self = StObject.set(x, "complete", js.undefined)
      
      inline def setError(value: Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      inline def setNext(value: /* value */ T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
      
      inline def setNextUndefined: Self = StObject.set(x, "next", js.undefined)
    }
  }
  
  trait NextObserver[T] extends StObject {
    
    var closed: js.UndefOr[Boolean] = js.undefined
    
    var complete: js.UndefOr[js.Function0[Unit]] = js.undefined
    
    var error: js.UndefOr[js.Function1[/* err */ Any, Unit]] = js.undefined
    
    def next(value: T): Unit
  }
  object NextObserver {
    
    inline def apply[T](next: T => Unit): NextObserver[T] = {
      val __obj = js.Dynamic.literal(next = js.Any.fromFunction1(next))
      __obj.asInstanceOf[NextObserver[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: NextObserver[?], T] (val x: Self & NextObserver[T]) extends AnyVal {
      
      inline def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      inline def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      inline def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      inline def setCompleteUndefined: Self = StObject.set(x, "complete", js.undefined)
      
      inline def setError(value: /* err */ Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      inline def setErrorUndefined: Self = StObject.set(x, "error", js.undefined)
      
      inline def setNext(value: T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
    }
  }
  
  trait Observer[T] extends StObject {
    
    var closed: js.UndefOr[Boolean] = js.undefined
    
    def complete(): Unit
    
    def error(err: Any): Unit
    
    def next(value: T): Unit
  }
  object Observer {
    
    inline def apply[T](complete: () => Unit, error: Any => Unit, next: T => Unit): Observer[T] = {
      val __obj = js.Dynamic.literal(complete = js.Any.fromFunction0(complete), error = js.Any.fromFunction1(error), next = js.Any.fromFunction1(next))
      __obj.asInstanceOf[Observer[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Observer[?], T] (val x: Self & Observer[T]) extends AnyVal {
      
      inline def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      inline def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      inline def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      inline def setError(value: Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      inline def setNext(value: T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
    }
  }
  
  type OperatorFunction[T, R] = UnaryFunction[Observable[T], Observable[R]]
  
  type PartialObserver[T] = NextObserver[T] | ErrorObserver[T] | CompletionObserver[T]
  
  @js.native
  trait SchedulerAction[T] extends Subscription {
    
    def schedule(): Subscription = js.native
    def schedule(state: T): Subscription = js.native
    def schedule(state: T, delay: Double): Subscription = js.native
    def schedule(state: Unit, delay: Double): Subscription = js.native
  }
  
  @js.native
  trait SchedulerLike extends StObject {
    
    def now(): Double = js.native
    
    def schedule[T](work: js.ThisFunction1[/* this */ SchedulerAction[T], /* state */ js.UndefOr[T], Unit]): Subscription = js.native
    def schedule[T](
      work: js.ThisFunction1[/* this */ SchedulerAction[T], /* state */ js.UndefOr[T], Unit],
      delay: Double
    ): Subscription = js.native
    def schedule[T](
      work: js.ThisFunction1[/* this */ SchedulerAction[T], /* state */ js.UndefOr[T], Unit],
      delay: Double,
      state: T
    ): Subscription = js.native
    def schedule[T](
      work: js.ThisFunction1[/* this */ SchedulerAction[T], /* state */ js.UndefOr[T], Unit],
      delay: Unit,
      state: T
    ): Subscription = js.native
  }
  
  @js.native
  trait Subscribable[T] extends StObject {
    
    def subscribe(): Unsubscribable = js.native
    def subscribe(observerOrNext: PartialObserver[T]): Unsubscribable = js.native
    def subscribe(observerOrNext: PartialObserver[T], error: js.Function1[/* error */ Any, Unit]): Unsubscribable = js.native
    def subscribe(
      observerOrNext: PartialObserver[T],
      error: js.Function1[/* error */ Any, Unit],
      complete: js.Function0[Unit]
    ): Unsubscribable = js.native
    def subscribe(observerOrNext: PartialObserver[T], error: Unit, complete: js.Function0[Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: js.Function1[/* value */ T, Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: js.Function1[/* value */ T, Unit], error: js.Function1[/* error */ Any, Unit]): Unsubscribable = js.native
    def subscribe(
      observerOrNext: js.Function1[/* value */ T, Unit],
      error: js.Function1[/* error */ Any, Unit],
      complete: js.Function0[Unit]
    ): Unsubscribable = js.native
    def subscribe(observerOrNext: js.Function1[/* value */ T, Unit], error: Unit, complete: js.Function0[Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: Unit, error: js.Function1[/* error */ Any, Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: Unit, error: js.Function1[/* error */ Any, Unit], complete: js.Function0[Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: Unit, error: Unit, complete: js.Function0[Unit]): Unsubscribable = js.native
  }
  
  trait SubscriptionLike
    extends StObject
       with Unsubscribable {
    
    val closed: Boolean
  }
  object SubscriptionLike {
    
    inline def apply(closed: Boolean, unsubscribe: () => Unit): SubscriptionLike = {
      val __obj = js.Dynamic.literal(closed = closed.asInstanceOf[js.Any], unsubscribe = js.Any.fromFunction0(unsubscribe))
      __obj.asInstanceOf[SubscriptionLike]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: SubscriptionLike] (val x: Self) extends AnyVal {
      
      inline def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
    }
  }
  
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
  
  trait Unsubscribable extends StObject {
    
    def unsubscribe(): Unit
  }
  object Unsubscribable {
    
    inline def apply(unsubscribe: () => Unit): Unsubscribable = {
      val __obj = js.Dynamic.literal(unsubscribe = js.Any.fromFunction0(unsubscribe))
      __obj.asInstanceOf[Unsubscribable]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Unsubscribable] (val x: Self) extends AnyVal {
      
      inline def setUnsubscribe(value: () => Unit): Self = StObject.set(x, "unsubscribe", js.Any.fromFunction0(value))
    }
  }
}
