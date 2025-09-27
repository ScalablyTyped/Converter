package org.scalablytyped.converter.internal
package phases

import com.olvind.logging.{Formatter, Logger}

import scala.collection.immutable.{SortedMap, SortedSet}
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

    next.cache.getOrElse((id, isCircular)) { () =>
      try {
        listener.on(next.name, id, PhaseListener.Started(next.name))

        val resLastPhase: PhaseRes[Id, T] =
          go(next.prev, id, Nil, getLogger, listener)

        def calculateDeps(newRequestedIds: SortedSet[Id]): PhaseRes[Id, SortedMap[Id, TT]] = {
          listener.on(next.name, id, PhaseListener.Blocked(next.name, newRequestedIds))

          val ret: PhaseRes[Id, SortedMap[Id, TT]] =
            PhaseRes.sequenceMap(
              scala.collection.immutable.SortedMap.from(newRequestedIds.iterator
                .map(thisId => thisId -> go(next, thisId, id :: circuitBreaker, getLogger, listener))),
            )

          listener.on(next.name, id, PhaseListener.Started(next.name))
          ret
        }

        val result: PhaseRes[Id, TT] =
          resLastPhase.flatMap(lastValue =>
            PhaseRes.attempt(id, logger, next.trans(id, lastValue, calculateDeps, isCircular, logger)),
          )

        result match {
          case PhaseRes.Ok(_) =>
            listener.on(next.name, id, PhaseListener.Success(next.name))
          case PhaseRes.Failure(errors) =>
            listener.on(next.name, id, PhaseListener.Failure(next.name, errors))
          case PhaseRes.Ignore() =>
            listener.on(next.name, id, PhaseListener.Ignored())
        }
        result

      } catch {
        case NonFatal(e) =>
          val errors = Map[Id, Either[Throwable, String]](id -> Left(e))
          listener.on(next.name, id, PhaseListener.Failure(next.name, errors))
          logger.error(("Failure", e))
          PhaseRes.Failure(errors)
      }
    }
  }
}
