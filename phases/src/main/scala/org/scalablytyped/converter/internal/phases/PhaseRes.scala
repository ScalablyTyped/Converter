package org.scalablytyped.converter.internal.phases

import java.nio.channels.{ClosedByInterruptException, FileLockInterruptionException}

import com.olvind.logging.Logger
import com.olvind.logging.Logger.LoggedException

import scala.collection.immutable.{SortedMap, TreeMap}
import scala.concurrent.ExecutionException
import scala.util.control.NonFatal

sealed trait PhaseRes[Id, T] extends Product with Serializable {
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

  def sequenceMap[Id: Ordering, T](rs: SortedMap[Id, PhaseRes[Id, T]]): PhaseRes[Id, SortedMap[Id, T]] =
    rs.foldLeft[PhaseRes[Id, SortedMap[Id, T]]](Ok(TreeMap.empty[Id, T])) {
      case (other, (_, Ignore()))                    => other
      case (Ok(map), (id, Ok(value)))                => Ok(map + ((id, value)))
      case (Ok(_), (_, Failure(errors)))             => Failure(errors)
      case (Failure(errors1), (_, Failure(errors2))) => Failure(errors1 ++ errors2)
      case (error @ Failure(_), _)                   => error
      case (Ignore(), (id, Ok(value)))               => Ok(TreeMap((id, value)))
      case (Ignore(), (_, Failure(errors)))          => Failure(errors)
    }

  def attempt[Id, T](id: Id, logger: Logger[Unit], t: => PhaseRes[Id, T]): PhaseRes[Id, T] =
    try t
    catch {
      case x: InterruptedException => throw x
      case x: ClosedByInterruptException => throw x
      case x: FileLockInterruptionException => throw x
      case x: ExecutionException if x.getCause != null =>
        val th = x.getCause
        logger.error(s"Caught exception: ${th.getMessage}", th)
        Failure[Id, T](Map(id -> Left(th)))
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
