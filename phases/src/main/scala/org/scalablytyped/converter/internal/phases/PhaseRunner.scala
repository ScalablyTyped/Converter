package org.scalablytyped.converter.internal
package phases

import java.nio.channels.{ClosedByInterruptException, FileLockInterruptionException}

import com.olvind.logging.{Formatter, Logger}

import scala.collection.immutable.{SortedMap, SortedSet}
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionException}
import scala.util.control.NonFatal

/**
  * Runs a computation given a sequence of input ids.
  */
object PhaseRunner {
  def apply[Id: Formatter: Ordering, T](
      phase:     RecPhase[Id, T],
      getLogger: Id => Logger[Unit],
      listener:  PhaseListener[Id],
  )(initial:     phase._Id): PhaseRes[phase._Id, phase._T] =
    go(phase, initial, Nil, getLogger, listener)

  def go[Id: Formatter: Ordering, TT](
      phase:          RecPhase[Id, TT],
      id:             Id,
      circuitBreaker: List[Id],
      getLogger:      Id => Logger[Unit],
      listener:       PhaseListener[Id],
  ): PhaseRes[Id, TT] =
    phase match {
      case _:    RecPhase.Initial[Id]     => PhaseRes.Ok[Id, TT](id)
      case next: RecPhase.Next[Id, t, TT] => doNext[Id, t, TT](next, id, circuitBreaker, getLogger, listener)
    }

  def doNext[Id: Formatter: Ordering, T, TT](
      next:           RecPhase.Next[Id, T, TT],
      id:             Id,
      circuitBreaker: List[Id],
      getLogger:      Id => Logger[Unit],
      listener:       PhaseListener[Id],
  ): PhaseRes[Id, TT] = {

    val isCircular = circuitBreaker contains id

    val logger = getLogger(id)
      .withContext(id)
      .withContext("thread", Thread.currentThread().getId)
      .withContext("phase", next.name)

    Await.result(
      next.cache.getOrElse((id, isCircular)) { p =>
        try {
          listener.on(next.name, id, PhaseListener.Started(next.name))

          val resLastPhase: PhaseRes[Id, T] =
            go(next.prev, id, Nil, getLogger, listener)

          def calculateDeps(newRequestedIds: SortedSet[Id]): PhaseRes[Id, SortedMap[Id, TT]] = {
            listener.on(next.name, id, PhaseListener.Blocked(next.name, newRequestedIds))

            val ret: PhaseRes[Id, SortedMap[Id, TT]] =
              PhaseRes.sequenceMap(
                newRequestedIds
                  .map(thisId => thisId -> go(next, thisId, id :: circuitBreaker, getLogger, listener))(
                    collection.breakOut,
                  ),
              )

            listener.on(next.name, id, PhaseListener.Started(next.name))

            ret match {
              case PhaseRes.Failure(errors) => logger.warn((s"Failed because of", errors))
              case _                        => ()
            }
            ret
          }

          val result: PhaseRes[Id, TT] =
            resLastPhase.flatMap(lastValue =>
              PhaseRes.attempt(id, logger, next.trans(id, lastValue, calculateDeps, isCircular, logger)),
            )

          result match {
            case res @ PhaseRes.Ok(_) =>
              listener.on(next.name, id, PhaseListener.Success(next.name))
              logger.debug("Success")
              p.success(res)
            case res @ PhaseRes.Failure(errors) =>
              listener.on(next.name, id, PhaseListener.Failure(next.name))
              logger.error(("Failure", errors))
              p.success(res)
            case res @ PhaseRes.Ignore() =>
              listener.on(next.name, id, PhaseListener.Ignored())
              logger.debug("Ignored")
              p.success(res)
          }
        } catch {
          case x: FileLockInterruptionException => throw x
          case x: InterruptedException => throw x
          case x: ClosedByInterruptException => throw x
          case x: ExecutionException if x.getCause != null =>
            val e = x.getCause
            listener.on(next.name, id, PhaseListener.Failure(next.name))
            logger.error(("Failure", e))
            p.success(PhaseRes.Failure(Map(id -> Left(e))))

          case NonFatal(e) =>
            listener.on(next.name, id, PhaseListener.Failure(next.name))
            logger.error(("Failure", e))
            p.success(PhaseRes.Failure(Map(id -> Left(e))))
        }
      },
      Duration.Inf,
    )
  }
}
