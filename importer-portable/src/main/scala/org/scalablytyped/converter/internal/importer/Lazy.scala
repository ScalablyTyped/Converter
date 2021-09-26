package org.scalablytyped.converter.internal.importer

import scala.util.control.NonFatal

// guard against circular evaluation
// may double-compute if not synchronized on the outside
sealed trait Lazy[T] {
  protected var state: Lazy.State[T] = Lazy.State.Initial

  def get: Option[T]

  final def map[U](f: T => U): Lazy[U] =
    new Lazy.Mapped(this, f)

  final def getIfEvaluated: Option[T] =
    state match {
      case Lazy.State.Initial | Lazy.State.Computing => None
      case Lazy.State.Done(value)                    => Some(value)
      case Lazy.State.Failed(th)                     => throw th
    }
}

object Lazy {
  def apply[T](compute: => T): Lazy[T] = new Lazy[T] {
    override def get: Option[T] =
      state match {
        case State.Initial =>
          state = State.Computing
          try {
            val computed = compute
            state = State.Done(computed)
            Some(computed)
          } catch {
            case NonFatal(th) =>
              state = State.Failed(th)
              throw th
          }
        case State.Computing   => None
        case State.Done(value) => Some(value)
        case State.Failed(th)  => throw th
      }
  }

  private final class Mapped[T, U](outer: Lazy[T], f: T => U) extends Lazy[U] {
    override def get: Option[U] =
      state match {
        case State.Initial =>
          outer.get.map { gotten =>
            state = State.Computing
            try {
              val computed = f(gotten)
              state = State.Done(computed)
              computed
            } catch {
              case NonFatal(th) =>
                state = State.Failed(th)
                throw th
            }
          }
        case State.Computing   => None
        case State.Done(value) => Some(value)
        case State.Failed(th)  => throw th
      }
  }

  sealed trait State[+T]
  object State {
    case object Initial extends State[Nothing]
    case object Computing extends State[Nothing]
    case class Done[T](value: T) extends State[T]
    case class Failed(th:     Throwable) extends State[Nothing]
  }
}
