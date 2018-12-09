package com.olvind.tso.phases

import com.olvind.logging.Logger
import com.olvind.logging.Logger.LoggedException

import scala.util.control.NonFatal

sealed trait PhaseRes[Id, T] {
  import PhaseRes._

  def foreach(f: T => Unit): PhaseRes[Id, Unit] = map(f)

  def map[U](f: T => U): PhaseRes[Id, U] =
    this match {
      case Ok(value)       => Ok(f(value))
      case Ignore()        => Ignore()
      case Failure(errors) => Failure(errors)
    }

  def flatMap[U](f: T => PhaseRes[Id, U]): PhaseRes[Id, U] =
    this match {
      case Ok(value)       => f(value)
      case Ignore()        => Ignore()
      case Failure(errors) => Failure(errors)
    }
}

object PhaseRes {
  final case class Ok[Id, T](value: T) extends PhaseRes[Id, T]
  final case class Ignore[Id, T]() extends PhaseRes[Id, T]
  final case class Failure[Id, T](errors: Map[Id, Either[Throwable, String]]) extends PhaseRes[Id, T]

  def fromEither[Id, L, R](id: Id, e: Either[String, R]): PhaseRes[Id, R] =
    e match {
      case Right(value) => Ok(value)
      case Left(error)  => Failure(Map(id -> Right(error)))
    }

  def fromOption[Id, T](id: Id, e: Option[T], onEmpty: => Either[Throwable, String]): PhaseRes[Id, T] =
    e match {
      case Some(value) => Ok(value)
      case None        => Failure(Map(id -> onEmpty))
    }

  def sequenceSet[Id, T](rs: Set[PhaseRes[Id, T]]): PhaseRes[Id, Set[T]] =
    rs.foldLeft[PhaseRes[Id, Set[T]]](Ok(Set.empty)) {
      case (other, Ignore())                 => other
      case (Ok(ts), Ok(t))                   => Ok(ts + t)
      case (Ok(_), Failure(errors))          => Failure(errors)
      case (Failure(errors), Failure(error)) => Failure(errors ++ error)
      case (error @ Failure(_), Ok(_))       => error
      case (Ignore(), Ok(t))                 => Ok(Set(t))
      case (Ignore(), Failure(error))        => Failure(error)
    }

  def sequenceMap[Id, T](rs: Map[Id, PhaseRes[Id, T]]): PhaseRes[Id, Map[Id, T]] =
    rs.foldLeft[PhaseRes[Id, Map[Id, T]]](Ok(Map.empty)) {
      case (other, (_, Ignore()))                    => other
      case (Ok(map), (id, Ok(value)))                => Ok(map + ((id, value)))
      case (Ok(_), (_, Failure(errors)))             => Failure(errors)
      case (Failure(errors1), (_, Failure(errors2))) => Failure(errors1 ++ errors2)
      case (error @ Failure(_), _)                   => error
      case (Ignore(), (id, Ok(value)))               => Ok(Map((id, value)))
      case (Ignore(), (_, Failure(errors)))          => Failure(errors)
    }

  def attempt[Id, T](id: Id, logger: Logger[Unit], t: => PhaseRes[Id, T]): PhaseRes[Id, T] =
    if (false) t
    else
      try t
      catch {
        case th: LoggedException =>
          Failure[Id, T](Map(id -> Left(th)))
        case NonFatal(th) =>
          logger.error(s"Caught exception: ${th.getMessage}", th)
          Failure[Id, T](Map(id -> Left(th)))
        case th: StackOverflowError =>
          logger.error("StackOverflowError", th)
          Failure[Id, T](Map(id -> Left(th)))
      }
}
