package typings.rxjs

import typings.rxjs.observableMod.Observable
import typings.rxjs.subscriptionMod.Subscription
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object typesMod {
  
  @js.native
  trait CompletionObserver[T]
    extends StObject
       with PartialObserver[T] {
    
    var closed: js.UndefOr[Boolean] = js.native
    
    def complete(): Unit = js.native
    
    var error: js.UndefOr[js.Function1[/* err */ js.Any, Unit]] = js.native
    
    var next: js.UndefOr[js.Function1[/* value */ T, Unit]] = js.native
  }
  object CompletionObserver {
    
    @scala.inline
    def apply[T](complete: () => Unit): CompletionObserver[T] = {
      val __obj = js.Dynamic.literal(complete = js.Any.fromFunction0(complete))
      __obj.asInstanceOf[CompletionObserver[T]]
    }
    
    @scala.inline
    implicit class CompletionObserverMutableBuilder[Self <: CompletionObserver[_], T] (val x: Self with CompletionObserver[T]) extends AnyVal {
      
      @scala.inline
      def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      @scala.inline
      def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      @scala.inline
      def setError(value: /* err */ js.Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      @scala.inline
      def setErrorUndefined: Self = StObject.set(x, "error", js.undefined)
      
      @scala.inline
      def setNext(value: /* value */ T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
      
      @scala.inline
      def setNextUndefined: Self = StObject.set(x, "next", js.undefined)
    }
  }
  
  @js.native
  trait ErrorObserver[T]
    extends StObject
       with PartialObserver[T] {
    
    var closed: js.UndefOr[Boolean] = js.native
    
    var complete: js.UndefOr[js.Function0[Unit]] = js.native
    
    def error(err: js.Any): Unit = js.native
    
    var next: js.UndefOr[js.Function1[/* value */ T, Unit]] = js.native
  }
  object ErrorObserver {
    
    @scala.inline
    def apply[T](error: js.Any => Unit): ErrorObserver[T] = {
      val __obj = js.Dynamic.literal(error = js.Any.fromFunction1(error))
      __obj.asInstanceOf[ErrorObserver[T]]
    }
    
    @scala.inline
    implicit class ErrorObserverMutableBuilder[Self <: ErrorObserver[_], T] (val x: Self with ErrorObserver[T]) extends AnyVal {
      
      @scala.inline
      def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      @scala.inline
      def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      @scala.inline
      def setCompleteUndefined: Self = StObject.set(x, "complete", js.undefined)
      
      @scala.inline
      def setError(value: js.Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      @scala.inline
      def setNext(value: /* value */ T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
      
      @scala.inline
      def setNextUndefined: Self = StObject.set(x, "next", js.undefined)
    }
  }
  
  @js.native
  trait NextObserver[T]
    extends StObject
       with PartialObserver[T] {
    
    var closed: js.UndefOr[Boolean] = js.native
    
    var complete: js.UndefOr[js.Function0[Unit]] = js.native
    
    var error: js.UndefOr[js.Function1[/* err */ js.Any, Unit]] = js.native
    
    def next(value: T): Unit = js.native
  }
  object NextObserver {
    
    @scala.inline
    def apply[T](next: T => Unit): NextObserver[T] = {
      val __obj = js.Dynamic.literal(next = js.Any.fromFunction1(next))
      __obj.asInstanceOf[NextObserver[T]]
    }
    
    @scala.inline
    implicit class NextObserverMutableBuilder[Self <: NextObserver[_], T] (val x: Self with NextObserver[T]) extends AnyVal {
      
      @scala.inline
      def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      @scala.inline
      def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      @scala.inline
      def setCompleteUndefined: Self = StObject.set(x, "complete", js.undefined)
      
      @scala.inline
      def setError(value: /* err */ js.Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      @scala.inline
      def setErrorUndefined: Self = StObject.set(x, "error", js.undefined)
      
      @scala.inline
      def setNext(value: T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
    }
  }
  
  @js.native
  trait Observer[T] extends StObject {
    
    var closed: js.UndefOr[Boolean] = js.native
    
    def complete(): Unit = js.native
    
    def error(err: js.Any): Unit = js.native
    
    def next(value: T): Unit = js.native
  }
  object Observer {
    
    @scala.inline
    def apply[T](complete: () => Unit, error: js.Any => Unit, next: T => Unit): Observer[T] = {
      val __obj = js.Dynamic.literal(complete = js.Any.fromFunction0(complete), error = js.Any.fromFunction1(error), next = js.Any.fromFunction1(next))
      __obj.asInstanceOf[Observer[T]]
    }
    
    @scala.inline
    implicit class ObserverMutableBuilder[Self <: Observer[_], T] (val x: Self with Observer[T]) extends AnyVal {
      
      @scala.inline
      def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClosedUndefined: Self = StObject.set(x, "closed", js.undefined)
      
      @scala.inline
      def setComplete(value: () => Unit): Self = StObject.set(x, "complete", js.Any.fromFunction0(value))
      
      @scala.inline
      def setError(value: js.Any => Unit): Self = StObject.set(x, "error", js.Any.fromFunction1(value))
      
      @scala.inline
      def setNext(value: T => Unit): Self = StObject.set(x, "next", js.Any.fromFunction1(value))
    }
  }
  
  type OperatorFunction[T, R] = UnaryFunction[Observable[T], Observable[R]]
  
  /* Rewritten from type alias, can be one of: 
    - typings.rxjs.typesMod.NextObserver[T]
    - typings.rxjs.typesMod.ErrorObserver[T]
    - typings.rxjs.typesMod.CompletionObserver[T]
  */
  trait PartialObserver[T] extends StObject
  object PartialObserver {
    
    @scala.inline
    def CompletionObserver[T](complete: () => Unit): typings.rxjs.typesMod.CompletionObserver[T] = {
      val __obj = js.Dynamic.literal(complete = js.Any.fromFunction0(complete))
      __obj.asInstanceOf[typings.rxjs.typesMod.CompletionObserver[T]]
    }
    
    @scala.inline
    def ErrorObserver[T](error: js.Any => Unit): typings.rxjs.typesMod.ErrorObserver[T] = {
      val __obj = js.Dynamic.literal(error = js.Any.fromFunction1(error))
      __obj.asInstanceOf[typings.rxjs.typesMod.ErrorObserver[T]]
    }
    
    @scala.inline
    def NextObserver[T](next: T => Unit): typings.rxjs.typesMod.NextObserver[T] = {
      val __obj = js.Dynamic.literal(next = js.Any.fromFunction1(next))
      __obj.asInstanceOf[typings.rxjs.typesMod.NextObserver[T]]
    }
  }
  
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
    def subscribe(observerOrNext: js.Function1[/* value */ T, Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: js.Function1[/* value */ T, Unit], error: js.Function1[/* error */ js.Any, Unit]): Unsubscribable = js.native
    def subscribe(
      observerOrNext: js.Function1[/* value */ T, Unit],
      error: js.Function1[/* error */ js.Any, Unit],
      complete: js.Function0[Unit]
    ): Unsubscribable = js.native
    def subscribe(observerOrNext: js.Function1[/* value */ T, Unit], error: Unit, complete: js.Function0[Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: Unit, error: js.Function1[/* error */ js.Any, Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: Unit, error: js.Function1[/* error */ js.Any, Unit], complete: js.Function0[Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: Unit, error: Unit, complete: js.Function0[Unit]): Unsubscribable = js.native
    def subscribe(observerOrNext: PartialObserver[T]): Unsubscribable = js.native
    def subscribe(observerOrNext: PartialObserver[T], error: js.Function1[/* error */ js.Any, Unit]): Unsubscribable = js.native
    def subscribe(
      observerOrNext: PartialObserver[T],
      error: js.Function1[/* error */ js.Any, Unit],
      complete: js.Function0[Unit]
    ): Unsubscribable = js.native
    def subscribe(observerOrNext: PartialObserver[T], error: Unit, complete: js.Function0[Unit]): Unsubscribable = js.native
  }
  
  @js.native
  trait SubscriptionLike
    extends StObject
       with Unsubscribable {
    
    val closed: Boolean = js.native
  }
  object SubscriptionLike {
    
    @scala.inline
    def apply(closed: Boolean, unsubscribe: () => Unit): SubscriptionLike = {
      val __obj = js.Dynamic.literal(closed = closed.asInstanceOf[js.Any], unsubscribe = js.Any.fromFunction0(unsubscribe))
      __obj.asInstanceOf[SubscriptionLike]
    }
    
    @scala.inline
    implicit class SubscriptionLikeMutableBuilder[Self <: SubscriptionLike] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setClosed(value: Boolean): Self = StObject.set(x, "closed", value.asInstanceOf[js.Any])
    }
  }
  
  type UnaryFunction[T, R] = js.Function1[/* source */ T, R]
  
  @js.native
  trait Unsubscribable extends StObject {
    
    def unsubscribe(): Unit = js.native
  }
  object Unsubscribable {
    
    @scala.inline
    def apply(unsubscribe: () => Unit): Unsubscribable = {
      val __obj = js.Dynamic.literal(unsubscribe = js.Any.fromFunction0(unsubscribe))
      __obj.asInstanceOf[Unsubscribable]
    }
    
    @scala.inline
    implicit class UnsubscribableMutableBuilder[Self <: Unsubscribable] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setUnsubscribe(value: () => Unit): Self = StObject.set(x, "unsubscribe", js.Any.fromFunction0(value))
    }
  }
}
